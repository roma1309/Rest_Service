package rest_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import rest_service.model.entity.Ship;
import rest_service.model.entity.ShipStatus;
import rest_service.model.enums.ShipStatusType;

import java.util.List;

public interface ShipRepository extends JpaRepository<Ship, Long> {

    List<Ship> findByStatus(ShipStatusType status);

    Ship findById(long id);

    void deleteById(long id);

    int countAllByPortId(long id);

}
