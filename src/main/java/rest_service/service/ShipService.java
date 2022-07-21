package rest_service.service;

import org.springframework.http.ResponseEntity;
import rest_service.model.dto.ShipDto;
import rest_service.model.entity.Ship;
import rest_service.model.entity.ShipStatus;

import java.util.List;

public interface ShipService {
    ResponseEntity<List<Ship>> readAllShip(String status);

    ResponseEntity<String> createShip(ShipDto shipDto);

    ResponseEntity<String> deleteShip(long id);

    ResponseEntity<ShipStatus> readShipStatus(long id);

    ResponseEntity<ShipStatus> updateShipStatus(long id, Long portId, ShipStatus status);
}

