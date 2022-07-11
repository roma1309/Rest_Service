package rest_service.dao;

import rest_service.model.entity.Port;

import java.util.List;

public interface PortDao {

    List<Port> selectAllPorts();

    Port selectPortById(long id);
}
