package rest_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import rest_service.model.entity.Ship;

public interface ShipRepository extends JpaRepository<Ship, Long> {
}
