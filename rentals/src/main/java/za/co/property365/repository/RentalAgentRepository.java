package za.co.property365.repository;

import org.springframework.data.repository.CrudRepository;
import za.co.property365.domain.RentalAgent;
import java.util.List;

public interface RentalAgentRepository extends CrudRepository<RentalAgent, Integer> {
    RentalAgent findByEmail(String email);
    List<RentalAgent> findBySuburb(String suburb);
    List<RentalAgent> findByName_FirstName(String firstName); // Use actual field name from Name class

    List<RentalAgent> findByName(String name);
}