package za.co.property365.factory;

import org.junit.jupiter.api.Test;
import za.co.property365.domain.Apartment;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentFactoryTest {

    @Test
    void testCreateApartment() {
        Apartment apartment = ApartmentFactory.createApartment(
                "123", "Main St", "Central", "Metropolis", 12345, 4500.0, 80
        );
        assertNotNull(apartment);
        assertEquals("123", apartment.getStreetNumber());
        assertEquals("Main St", apartment.getStreetName());
        assertEquals("Central", apartment.getSuburb());
        assertEquals("Metropolis", apartment.getCity());
        assertEquals(12345, apartment.getPostalCode());
        assertEquals(4500.0, apartment.getRentalCost());
        assertEquals(80, apartment.getFloorSize());
    }
}