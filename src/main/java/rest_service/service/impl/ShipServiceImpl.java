package rest_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rest_service.dao.ShipDao;
import rest_service.model.entity.Ship;
import rest_service.service.ShipService;

import java.util.List;

@Service
public class ShipServiceImpl implements ShipService {
    private final ShipDao shipDao;

    @Autowired
    public ShipServiceImpl(ShipDao shipDao) {
        this.shipDao = shipDao;
    }

    @Override
    public ResponseEntity<List<Ship>> readAllShip(String status) {
        return null;
    }

    @Override
    public ResponseEntity<String> createShip(Ship ship) {
        return null;
    }
}
