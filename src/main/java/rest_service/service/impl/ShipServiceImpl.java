package rest_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest_service.dao.ShipDao;
import rest_service.service.ShipService;

@Service
public class ShipServiceImpl implements ShipService {
    private final ShipDao shipDao;

    @Autowired
    public ShipServiceImpl(ShipDao shipDao) {
        this.shipDao = shipDao;
    }
}
