package za.co.property365.factory;

import za.co.property365.domain.House;

public class HouseFactory {
    public static House createHouse() {
        return new House.Builder()
                .streetNumber("123")
                .streetName("Main St")
                .suburb("Suburbia")
                .city("Metropolis")
                .postalCode(12345)
                .rentalCost(1500.00)
                .erfSize(500)
                .build();
    }

    public static House createHouse(String streetNumber, String streetName, String suburb, String city, Integer postalCode, double rentalCost, Integer erfSize) {
        return new House.Builder()
                .streetNumber(streetNumber)
                .streetName(streetName)
                .suburb(suburb)
                .city(city)
                .postalCode(postalCode)
                .rentalCost(rentalCost)
                .erfSize(erfSize)
                .build();
    }
}