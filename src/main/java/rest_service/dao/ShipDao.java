package rest_service.dao;

import rest_service.model.entity.Ship;
import rest_service.model.enums.ShipStatusType;

import java.util.List;

public interface ShipDao {
    List<Ship> selectAllShips();

    List<Ship> selectShipsByStatus(ShipStatusType status);

    int selectShipsCountByPortId(long id);

    Ship selectShipById(long id);

    void insertShip(Ship ship);

    void deleteShipById(long id);

}
