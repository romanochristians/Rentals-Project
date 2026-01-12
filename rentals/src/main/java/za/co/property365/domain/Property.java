package za.co.property365.domain;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long propertyId;

    private String streetNumber;
    private String streetName;
    private String suburb;
    private String city;
    private Integer postalCode;
    private double rentalCost;

    @ManyToOne
    @JoinColumn(name = "rental_agent_id")
    private RentalAgent rentalAgent;

    public Property() {}

    protected Property(Builder<?> builder) {
        this.propertyId = builder.propertyId;
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.suburb = builder.suburb;
        this.city = builder.city;
        this.postalCode = builder.postalCode;
        this.rentalCost = builder.rentalCost;
        this.rentalAgent = builder.rentalAgent;
    }

    public abstract String getPropertyType();

    public static abstract class Builder<T extends Builder<T>> {
        private Long propertyId;
        private String streetNumber;
        private String streetName;
        private String suburb;
        private String city;
        private Integer postalCode;
        private double rentalCost;
        private RentalAgent rentalAgent;

        public T propertyId(Long propertyId) { this.propertyId = propertyId; return self(); }
        public T streetNumber(String streetNumber) { this.streetNumber = streetNumber; return self(); }
        public T streetName(String streetName) { this.streetName = streetName; return self(); }
        public T suburb(String suburb) { this.suburb = suburb; return self(); }
        public T city(String city) { this.city = city; return self(); }
        public T postalCode(Integer postalCode) { this.postalCode = postalCode; return self(); }
        public T rentalCost(double rentalCost) { this.rentalCost = rentalCost; return self(); }
        public T rentalAgent(RentalAgent rentalAgent) { this.rentalAgent = rentalAgent; return self(); }
        protected abstract T self();
        public abstract Property build();
    }

    public Long getPropertyId() { return propertyId; }
    public void setPropertyId(Long propertyId) { this.propertyId = propertyId; }
    public String getStreetNumber() { return streetNumber; }
    public void setStreetNumber(String streetNumber) { this.streetNumber = streetNumber; }
    public String getStreetName() { return streetName; }
    public void setStreetName(String streetName) { this.streetName = streetName; }
    public String getSuburb() { return suburb; }
    public void setSuburb(String suburb) { this.suburb = suburb; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public Integer getPostalCode() { return postalCode; }
    public void setPostalCode(Integer postalCode) { this.postalCode = postalCode; }
    public double getRentalCost() { return rentalCost; }
    public void setRentalCost(double rentalCost) { this.rentalCost = rentalCost; }
    public RentalAgent getRentalAgent() { return rentalAgent; }
    public void setRentalAgent(RentalAgent rentalAgent) { this.rentalAgent = rentalAgent; }

    @Override
    public String toString() {
        return "Property{" +
                "propertyId=" + propertyId +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", postalCode=" + postalCode +
                ", rentalCost=" + rentalCost +
                ", rentalAgent=" + (rentalAgent != null ? rentalAgent.getId() : null) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Property)) return false;
        Property property = (Property) o;
        if (Double.compare(property.rentalCost, rentalCost) != 0) return false;
        if (!propertyId.equals(property.propertyId)) return false;
        if (!streetNumber.equals(property.streetNumber)) return false;
        if (!streetName.equals(property.streetName)) return false;
        if (!suburb.equals(property.suburb)) return false;
        if (!city.equals(property.city)) return false;
        return postalCode.equals(property.postalCode);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = propertyId.hashCode();
        result = 31 * result + streetNumber.hashCode();
        result = 31 * result + streetName.hashCode();
        result = 31 * result + suburb.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + postalCode.hashCode();
        temp = Double.doubleToLongBits(rentalCost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}