package rest_service.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import rest_service.dao.PortDao;
import rest_service.model.entity.Port;
import rest_service.repo.PortRepository;

import java.util.List;

public class PortDaoImpl implements PortDao {
    private final PortRepository portRepository;

    @Autowired
    public PortDaoImpl(PortRepository portRepository) {
        this.portRepository = portRepository;
    }

    @Override
    public List<Port> selectAllPorts() {
        return portRepository.findAll();
    }

    @Override
    public Port selectPortById(long id) {
        return portRepository.findById(id);
    }
}
