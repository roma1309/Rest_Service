package rest_service.service;

import org.springframework.http.ResponseEntity;
import rest_service.model.entity.Ship;

import java.util.List;

public interface ShipService {
    ResponseEntity<List<Ship>> readAllShip(String status);

    ResponseEntity<String> createShip(Ship ship);

    ResponseEntity<String> deleteShip(long id);
}

