package za.co.property365.domain;

import jakarta.persistence.Entity;

@Entity
public class Apartment extends Property {
    private String apartmentName;
    private String apartmentNumber;
    private int floorSize;

    public Apartment() {}

    private Apartment(Builder builder) {
        super(builder);
        this.apartmentName = builder.apartmentName;
        this.apartmentNumber = builder.apartmentNumber;
        this.floorSize = builder.floorSize;
    }

    public String getApartmentName() { return apartmentName; }
    public void setApartmentName(String apartmentName) { this.apartmentName = apartmentName; }
    public String getApartmentNumber() { return apartmentNumber; }
    public void setApartmentNumber(String apartmentNumber) { this.apartmentNumber = apartmentNumber; }
    public int getFloorSize() { return floorSize; }
    public void setFloorSize(int floorSize) { this.floorSize = floorSize; }

    public static class Builder extends Property.Builder<Builder> {
        private String apartmentName;
        private String apartmentNumber;
        private int floorSize;

        public Builder apartmentName(String apartmentName) { this.apartmentName = apartmentName; return this; }
        public Builder apartmentNumber(String apartmentNumber) { this.apartmentNumber = apartmentNumber; return this; }
        public Builder floorSize(int floorSize) { this.floorSize = floorSize; return this; }
        @Override protected Builder self() { return this; }
        @Override public Apartment build() { return new Apartment(this); }
    }

    @Override
    public String getPropertyType() { return "Apartment"; }
}