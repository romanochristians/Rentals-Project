package za.co.property365.repository;

import org.springframework.data.repository.CrudRepository;
import za.co.property365.domain.Apartment;
import java.util.List;

public interface ApartmentRepository extends CrudRepository<Apartment, Integer> {
    List<Apartment> findBySuburb(String suburb);
    List<Apartment> findByRentalCostLessThan(double maxRentalCost);

    // Example: find by full address
    Apartment findByStreetNumberAndStreetNameAndSuburbAndCity(
            String streetNumber, String streetName, String suburb, String city
    );
}