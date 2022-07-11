package rest_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest_service.model.entity.Port;
import rest_service.service.PortService;
import rest_service.service.impl.PortServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/ports", produces = "application/json")
public class PortController {
    private final PortService portService;

    @Autowired
    public PortController(PortService portService) {
        this.portService = portService;
    }

    @GetMapping
    public ResponseEntity<List<Port>> getAllPorts() {
        return portService.readAllPorts();
    }

    @GetMapping("/{id}/capacity")
    public ResponseEntity<String> getPortCapacityInfo(
            @PathVariable(value = "id") final long id) {
        return portService.readPortCapacityInfo(id);
    }
}
