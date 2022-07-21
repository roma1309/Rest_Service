package rest_service.service.impl;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rest_service.dao.PortDao;
import rest_service.dao.ShipDao;
import rest_service.model.dto.ShipDto;
import rest_service.model.entity.Port;
import rest_service.model.entity.Ship;
import rest_service.model.entity.ShipStatus;
import rest_service.model.enums.ShipStatusType;
import rest_service.service.ShipService;

import java.util.List;

@Service
public class ShipServiceImpl implements ShipService {
    private final ShipDao shipDao;
    private final PortDao portDao;

    @Autowired

    public ShipServiceImpl(ShipDao shipDao, PortDao portDao) {
        this.shipDao = shipDao;
        this.portDao = portDao;
    }

    @Override
    public ResponseEntity<List<Ship>> readAllShip(String status) {
        if (status == null) {
            return ResponseEntity.ok(shipDao.selectAllShips());
        }
        ShipStatusType shipStatusType = ShipStatusType.getStatusType(status);
        if (shipStatusType == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(shipDao.selectShipsByStatus(shipStatusType));
    }

    @Override
    public ResponseEntity<String> createShip(ShipDto shipDto) {
        if (shipDto == null || shipDto.getName() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        final Long portId = shipDto.getPortId();
        System.out.println("port " + shipDto.getPortId());
        if (portId == 0) {
            Ship ship = new Ship(shipDto.getName(), ShipStatusType.SEA, null);
            shipDao.insertShip(ship);
            final JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", ship.getId());
            return ResponseEntity.ok(jsonObject.toString());
        }
        final Port port = portDao.selectPortById(shipDto.getPortId());
        if (port == null) {
            System.out.println(port.toString());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        final int countShipInPort = shipDao.selectShipsCountByPortId(port.getId());
        if (countShipInPort < port.getCapacity()) {
            Ship ship = new Ship(shipDto.getName(), ShipStatusType.PORT, port);
            shipDao.insertShip(ship);
            final JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", ship.getId());
            return ResponseEntity.ok(jsonObject.toString());
        } else {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
    }

    @Override
    public ResponseEntity<String> deleteShip(long id) {
        final Ship ship = shipDao.selectShipById(id);
        System.out.println(ship.getPort());
        if (ship == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        shipDao.deleteShipById(ship.getId());
        return ResponseEntity.ok("");
    }

    @Override
    public ResponseEntity<ShipStatus> readShipStatus(long id) {
        final Ship ship = shipDao.selectShipById(id);
        if (ship == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        final ShipStatus status = new ShipStatus();
        status.setStatus(ship.getStatus().name());
        return ResponseEntity.ok(status);
    }

    @Override
    public ResponseEntity<ShipStatus> updateShipStatus(long id, Long portId, ShipStatus status) {
        System.out.println(portId);
        final Ship ship = shipDao.selectShipById(id);
        if (ship == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        ShipStatusType shipStatusType = ShipStatusType.getStatusType(status.getStatus());
        if (shipStatusType == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        switch (shipStatusType) {
            case SEA:
                if (ship.getStatus() != ShipStatusType.SEA) {
                    ship.setStatus(ShipStatusType.SEA);
                    ship.setPort(null);
                    shipDao.insertShip(ship);
                    System.out.println("status -- " + shipStatusType);
                }
                break;
            case PORT:
                if (ship.getStatus() != ShipStatusType.PORT) {
                    if (portId == 0) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
                    }
                    final Port port = portDao.selectPortById(portId);
                    System.out.println(port.toString());
                    if (port == null) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                    }
                    final int shipsInPortCount = shipDao.selectShipsCountByPortId(portId);
                    if (shipsInPortCount < port.getCapacity()) {
                        ship.setStatus(ShipStatusType.PORT);
                        ship.setPort(port);
                        shipDao.insertShip(ship);
                    } else {
                        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
                    }
                }
                break;
            default:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        ShipStatus newShipStatus = new ShipStatus();
        newShipStatus.setStatus(ship.getStatus().name());
        return ResponseEntity.ok(newShipStatus);
    }
}
