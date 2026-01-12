package za.co.property365.service;

import za.co.property365.domain.House;
import java.util.List;
import java.util.Optional;

/**
 * IHouseService.java
 * Extends the IService interface
 * Includes method declarations for - findBySuburb, findByRentalCostLessThan
 */
public interface IHouseService extends IService<House, Integer> {
    Optional<House> read(Integer id);

    void delete(Integer id);

    List<House> getAll();

    List<House> findBySuburb(String suburb);
    List<House> findByRentalCostLessThan(double maxRentalCost);
}