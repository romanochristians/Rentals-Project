package za.co.property365.factory;

import za.co.property365.domain.Apartment;

public class ApartmentFactory {
    public static Apartment createApartment(
            String streetNumber,
            String streetName,
            String suburb,
            String city,
            Integer postalCode,
            double rentalCost,
            int floorSize
    ) {
        return new Apartment.Builder()
                .streetNumber(streetNumber)
                .streetName(streetName)
                .suburb(suburb)
                .city(city)
                .postalCode(postalCode)
                .rentalCost(rentalCost)
                .floorSize(floorSize)
                .build();
    }
}