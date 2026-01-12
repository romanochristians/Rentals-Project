package za.co.property365.service;

import za.co.property365.domain.Apartment;

import java.util.List;
import java.util.Optional;

/**
 * IApartmentService.java
 * Extends the IService interface
 * ToDo: Also include method declarations for - findBySuburb, findByRentalCostLessThan
 */

public interface IApartmentService extends IService<Apartment, Integer> {
    List<Apartment> getAll();

    List<Apartment> findBySuburb(String suburb);
  List<Apartment> findByRentalCostLessThan(double maxRentalCost);
}