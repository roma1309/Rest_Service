package rest_service.model.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import rest_service.model.entity.Port;
import rest_service.model.enums.ShipStatusType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

public class ShipDto {

    private String name;
    private long portId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPortId() {
        return portId;
    }

    public void setPortId(long portId) {
        this.portId = portId;
    }
}
