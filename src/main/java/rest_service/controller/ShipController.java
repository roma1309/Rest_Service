package rest_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest_service.model.entity.Ship;
import rest_service.service.ShipService;

import java.util.List;

@RestController
@RequestMapping(value = "/ships", produces = "application/json")
public class ShipController {
    private final ShipService shipService;

    @Autowired
    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping
    public ResponseEntity<List<Ship>> getAllShips(
            @RequestParam(value = "status", required = false) final String status) {
        return shipService.readAllShip(status);
    }

    @PostMapping
    public ResponseEntity<String> postShip(
            @RequestBody final Ship ship
    ) {
        return shipService.createShip(ship);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShip(
            @PathVariable(value = "id") final long id) {
        return shipService.deleteShip(id);
    }

}
