package rest_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import rest_service.model.entity.Ship;
import rest_service.model.enums.ShipStatusType;

import java.util.List;

public interface ShipRepository extends JpaRepository<Ship, Long> {

    List<Ship> findByStatus(ShipStatusType status);

    Ship findById(long id);

    void removeById(long id);

    int countAllByPortId(long id);

}
