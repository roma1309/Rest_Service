package rest_service.model.entity;

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
    @NotEmpty
    @Enumerated(EnumType.STRING)
    private ShipStatusType status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "port_id")
    private Port port;
}
