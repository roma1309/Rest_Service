package rest_service.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rest_service.dao.ShipDao;
import rest_service.model.entity.Ship;
import rest_service.model.enums.ShipStatusType;
import rest_service.repo.ShipRepository;

import java.util.List;

@Repository
public class ShipDaoImpl implements ShipDao {
    private final ShipRepository shipRepository;

    @Autowired
    public ShipDaoImpl(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    @Override
    public List<Ship> selectAllShips() {
        return shipRepository.findAll();
    }

    @Override
    public List<Ship> selectShipsByStatus(ShipStatusType status) {
        return shipRepository.findByStatus(status);
    }

    @Override
    public int selectShipsCountByPortId(long id) {
        return shipRepository.countAllByPortId(id);
    }

    @Override
    public Ship selectShipById(long id) {
        return shipRepository.findById(id);
    }

    @Override
    public void insertShip(Ship ship) {
        shipRepository.save(ship);
    }

    @Override
    public void deleteShipById(long id) {
        shipRepository.removeById(id);
    }

    @Override
    public void updateShipStatusById(long id, ShipStatusType status) {

    }

    @Override
    public void updateShipPortIdById(long id, Long portId) {

    }
}
