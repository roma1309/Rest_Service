package rest_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import rest_service.model.entity.Port;

public interface PortRepository extends JpaRepository<Port, Long> {

    Port findById(long id);
}
