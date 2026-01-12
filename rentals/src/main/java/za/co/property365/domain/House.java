package za.co.property365.domain;

import jakarta.persistence.Entity;

@Entity
public class House extends Property {
    private Integer erfSize;

    public House() {}

    private House(Builder builder) {
        super(builder);
        this.erfSize = builder.erfSize;
    }

    public Integer getErfSize() { return erfSize; }
    public void setErfSize(Integer erfSize) { this.erfSize = erfSize; }

    public static class Builder extends Property.Builder<Builder> {
        private Integer erfSize;

        public Builder erfSize(Integer erfSize) { this.erfSize = erfSize; return this; }
        @Override protected Builder self() { return this; }
        @Override public House build() { return new House(this); }
    }

    @Override
    public String getPropertyType() { return "House"; }
}