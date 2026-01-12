package za.co.property365.factory;

import za.co.property365.domain.RentalAgent;
import za.co.property365.domain.Name;

public class RentalAgentFactory {
    public static RentalAgent createRentalAgent() {
        Name name = new Name.Builder()
                .firstName("Mike")
                .middleName("Desmond")
                .lastName("Jones")
                .build();
        return new RentalAgent.Builder()
                .name(name)
                .email("mikejones@gmail.com")
                .phoneMobile("0727196078")
                .build();
    }

    public static RentalAgent createRentalAgent(Name name, String email, String phoneMobile) {
        return new RentalAgent.Builder()
                .name(name)
                .email(email)
                .phoneMobile(phoneMobile)
                .build();
    }
}