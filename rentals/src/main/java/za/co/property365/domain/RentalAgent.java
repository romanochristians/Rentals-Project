package za.co.property365.domain;

import jakarta.persistence.*;

@Entity
public class RentalAgent {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Name name;

    private String email;
    private String Mobile;

    public RentalAgent() {
        // Default constructor for JPA
    }

    private RentalAgent(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.Mobile = builder.Mobile;
    }

    public static class Builder {
        private Name name;
        private String email;
        private String Mobile;

        public Builder name(Name name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phoneMobile(String phoneMobile) {
            this.Mobile = phoneMobile;
            return this;
        }

        public RentalAgent build() {
            return new RentalAgent(this);
        }
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneMobile() {
        return Mobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.Mobile = phoneMobile;
    }

    @Override
    public String toString() {
        return "RentalAgent{" +
                "name=" + name +
                ", email='" + email + '\'' +
                ", phoneMobile='" + Mobile + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }
}