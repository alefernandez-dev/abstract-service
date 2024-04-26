package alexdev.abstractservice.infrastructure.db.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FoodJpaRepository extends JpaRepository<FoodJpa, UUID> {

    boolean existsByName(String name);
   // Optional<FoodJpa> findByName(String name);

}
