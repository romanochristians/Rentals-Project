package za.co.property365.service;

import za.co.property365.domain.RentalAgent;

import java.util.List;

/**
 * IRentallService.java
 * ToDo: Methods declarations for - save, read, delete
 */

public interface IRentalAgentService {
    RentalAgent save(RentalAgent rentalAgent);
    RentalAgent read(Integer id);
    void delete(Integer id);

    RentalAgent update(RentalAgent rentalAgent);

    void deleteById(Integer id);

    void delete(RentalAgent rentalAgent);

    Iterable<RentalAgent> getAll();

    List<RentalAgent> findBySuburb(String suburb);

    List<RentalAgent> findByName(String name);
}