package rest_service.dao.impl;

import rest_service.dao.ShipDao;
import rest_service.model.entity.Ship;
import rest_service.model.enums.ShipStatusType;

import java.util.List;

public class ShipDaoImpl implements ShipDao {
    @Override
    public List<Ship> selectAllShips() {
        return null;
    }

    @Override
    public List<Ship> selectShipsByStatus(ShipStatusType status) {
        return null;
    }

    @Override
    public int selectShipsCountByPortId(long id) {
        return 0;
    }

    @Override
    public Ship selectShipById(long id) {
        return null;
    }

    @Override
    public void insertShip(Ship ship) {

    }

    @Override
    public void deleteShipById(long id) {

    }

    @Override
    public void updateShipStatusById(long id, ShipStatusType status) {

    }

    @Override
    public void updateShipPortIdById(long id, Long portId) {

    }
}
