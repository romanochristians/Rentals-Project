package za.co.property365.factory;

import org.junit.jupiter.api.Test;
import za.co.property365.domain.RentalAgent;
import za.co.property365.domain.Name;
import za.co.property365.factory.RentalAgentFactory;

import static org.junit.jupiter.api.Assertions.*;

class RentalAgentFactoryTest {

    @Test
    void testCreateRentalAgentDefault() {
        RentalAgent agent = RentalAgentFactory.createRentalAgent();
        assertNotNull(agent);
        assertNotNull(agent.getName());
        assertEquals("Mike", agent.getName().getFirstName());
        assertEquals("Desmond", agent.getName().getMiddleName());
        assertEquals("Jones", agent.getName().getLastName());
        assertEquals("mikejones@gmail.com", agent.getEmail());
        assertEquals("0727196078", agent.getPhoneMobile());
    }

    @Test
    void testCreateRentalAgentWithParams() {
        Name name = new Name.Builder()
                .firstName("Anna")
                .middleName("Marie")
                .lastName("Smith")
                .build();
        RentalAgent agent = RentalAgentFactory.createRentalAgent(name, "anna.smith@example.com", "0812345678");
        assertNotNull(agent);
        assertEquals("Anna", agent.getName().getFirstName());
        assertEquals("Marie", agent.getName().getMiddleName());
        assertEquals("Smith", agent.getName().getLastName());
        assertEquals("anna.smith@example.com", agent.getEmail());
        assertEquals("0812345678", agent.getPhoneMobile());
    }
}