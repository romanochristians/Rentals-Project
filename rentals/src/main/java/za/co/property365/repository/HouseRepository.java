// src/main/java/za/co/property365/repository/HouseRepository.java
package za.co.property365.repository;

import org.springframework.data.repository.CrudRepository;
import za.co.property365.domain.House;
import java.util.List;

public interface HouseRepository extends CrudRepository<House, Integer> {
    List<House> findByStreetName(String streetName);
    List<House> findBySuburb(String suburb);
    List<House> findByRentalCostLessThan(double maxRentalCost);
}