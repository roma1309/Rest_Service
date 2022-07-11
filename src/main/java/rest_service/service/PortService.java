package rest_service.service;

import org.springframework.http.ResponseEntity;
import rest_service.model.entity.Port;

import java.util.List;

public interface PortService {

    ResponseEntity<List<Port>> readAllPorts();

    ResponseEntity<String> readPortCapacityInfo(long id);
}
