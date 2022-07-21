package rest_service.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest_service.model.entity.Port;
import rest_service.service.PortService;

import java.util.List;

@RestController
@RequestMapping(value = "/ports", produces = "application/json")
@Api(value = "/ports", tags = "Порты")
public class PortController {
    private final PortService portService;

    @Autowired
    public PortController(PortService portService) {
        this.portService = portService;
    }

    @GetMapping
    @ApiOperation(value = "Получить сведения о портах",
            httpMethod = "GET",
            produces = "application/json",
            response = Port.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка")
    })
    public ResponseEntity<List<Port>> getAllPorts() {
        return portService.readAllPorts();
    }

    @GetMapping("/{id}/capacity")
    @ApiOperation(value = "Получить сведения о местах в порту",
            httpMethod = "GET",
            produces = "application/json",
            response = Port.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Порт не найден"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка")
    })
    public ResponseEntity<String> getPortCapacityInfo(
            @ApiParam(
                    value = "id порта",
                    name = "id",
                    required = true,
                    example = "3"
            )
            @PathVariable(value = "id") final long id) {
        return portService.readPortCapacityInfo(id);
    }
}
