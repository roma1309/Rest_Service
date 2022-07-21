package rest_service.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import rest_service.model.enums.ShipStatusType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @Enumerated(EnumType.STRING)
    private ShipStatusType status;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "port_id")
    private Port port;

    public Ship() {
    }

    public Ship(String name, ShipStatusType status, Port port) {
        this.name = name;
        this.status = status;
        this.port = port;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShipStatusType getStatus() {
        return status;
    }

    public void setStatus(ShipStatusType status) {
        this.status = status;
    }

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    public Ship(Long id, String name, ShipStatusType status, Port port) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.port = port;
    }
}
