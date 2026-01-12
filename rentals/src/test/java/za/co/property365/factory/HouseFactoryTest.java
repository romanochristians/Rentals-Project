package za.co.property365.factory;

import org.junit.jupiter.api.Test;
import za.co.property365.domain.House;
import za.co.property365.factory.HouseFactory;

import static org.junit.jupiter.api.Assertions.*;

class HouseFactoryTest {

    @Test
    void testCreateHouse() {
        House house = HouseFactory.createHouse(
                "123", "Main St", "Suburbia", "Metropolis", 12345, 1500.00, 500
        );
        assertNotNull(house);
        assertEquals("123", house.getStreetNumber());
        assertEquals("Main St", house.getStreetName());
        assertEquals("Suburbia", house.getSuburb());
        assertEquals("Metropolis", house.getCity());
        assertEquals(12345, house.getPostalCode());
        assertEquals(1500.00, house.getRentalCost());
        assertEquals(500, house.getErfSize());
    }
}