package za.co.property365.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import za.co.property365.domain.RentalAgent;
import za.co.property365.factory.RentalAgentFactory;
import za.co.property365.repository.RentalAgentRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RentalAgentServiceTest {

    @Mock
    private RentalAgentRepository rentalAgentRepository;

    @InjectMocks
    private RentalAgentService rentalAgentService;

    private RentalAgent rentalAgent;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        rentalAgent = RentalAgentFactory.createRentalAgent();
    }

    @Test
    void testSave() {
        when(rentalAgentRepository.save(rentalAgent)).thenReturn(rentalAgent);
        RentalAgent saved = rentalAgentService.save(rentalAgent);
        assertNotNull(saved);
        assertEquals(rentalAgent, saved);
        verify(rentalAgentRepository).save(rentalAgent);
    }

    @Test
    void testRead() {
        when(rentalAgentRepository.findById(1)).thenReturn(Optional.of(rentalAgent));
        RentalAgent found = rentalAgentService.read(1);
        assertNotNull(found);
        assertEquals(rentalAgent, found);
        verify(rentalAgentRepository).findById(1);
    }

    @Test
    void testUpdate() {
        when(rentalAgentRepository.save(rentalAgent)).thenReturn(rentalAgent);
        RentalAgent updated = rentalAgentService.update(rentalAgent);
        assertNotNull(updated);
        assertEquals(rentalAgent, updated);
        verify(rentalAgentRepository).save(rentalAgent);
    }

    @Test
    void testDeleteById() {
        doNothing().when(rentalAgentRepository).deleteById(1);
        rentalAgentService.deleteById(1);
        verify(rentalAgentRepository).deleteById(1);
    }

    @Test
    void testDelete() {
        doNothing().when(rentalAgentRepository).delete(rentalAgent);
        rentalAgentService.delete(rentalAgent);
        verify(rentalAgentRepository).delete(rentalAgent);
    }

    @Test
    void testGetAll() {
        List<RentalAgent> agents = Arrays.asList(rentalAgent);
        when(rentalAgentRepository.findAll()).thenReturn(agents);
        List<RentalAgent> result = rentalAgentService.getAll();
        assertEquals(1, result.size());
        verify(rentalAgentRepository).findAll();
    }

    @Test
    void testFindBySuburb() {
        List<RentalAgent> agents = Arrays.asList(rentalAgent);
        when(rentalAgentRepository.findBySuburb("Central")).thenReturn(agents);
        List<RentalAgent> result = rentalAgentService.findBySuburb("Central");
        assertEquals(1, result.size());
        verify(rentalAgentRepository).findBySuburb("Central");
    }

    @Test
    void testFindByName() {
        List<RentalAgent> agents = Arrays.asList(rentalAgent);
        when(rentalAgentRepository.findByName("Mike")).thenReturn(agents);
        List<RentalAgent> result = rentalAgentService.findByName("Mike");
        assertEquals(1, result.size());
        verify(rentalAgentRepository).findByName("Mike");
    }
}