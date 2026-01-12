package za.co.property365.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import za.co.property365.domain.Apartment;
import za.co.property365.repository.ApartmentRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ApartmentServiceTest {

    @Mock
    private ApartmentRepository apartmentRepository;

    @InjectMocks
    private ApartmentService apartmentService;

    private Apartment apartment;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        apartment = new Apartment.Builder()
                .streetNumber("123")
                .streetName("Main St")
                .suburb("Central")
                .city("Metropolis")
                .postalCode(12345)
                .rentalCost(4500.0)
                .floorSize(80)
                .build();
    }

    @Test
    void testSave() {
        when(apartmentRepository.save(apartment)).thenReturn(apartment);
        Apartment saved = apartmentService.save(apartment);
        assertNotNull(saved);
        assertEquals(apartment, saved);
        verify(apartmentRepository).save(apartment);
    }

    @Test
    void testFindById() {
        when(apartmentRepository.findById(1)).thenReturn(Optional.of(apartment));
        Optional<Apartment> found = apartmentService.findById(1);
        assertTrue(found.isPresent());
        assertEquals(apartment, found.get());
        verify(apartmentRepository).findById(1);
    }

    @Test
    void testUpdate() {
        when(apartmentRepository.save(apartment)).thenReturn(apartment);
        Apartment updated = apartmentService.update(apartment);
        assertNotNull(updated);
        assertEquals(apartment, updated);
        verify(apartmentRepository).save(apartment);
    }

    @Test
    void testDeleteById() {
        doNothing().when(apartmentRepository).deleteById(1);
        apartmentService.deleteById(1);
        verify(apartmentRepository).deleteById(1);
    }

    @Test
    void testGetAll() {
        List<Apartment> apartments = Arrays.asList(apartment);
        when(apartmentRepository.findAll()).thenReturn(apartments);
        List<Apartment> result = apartmentService.getAll();
        assertEquals(1, result.size());
        verify(apartmentRepository).findAll();
    }

    @Test
    void testFindBySuburb() {
        List<Apartment> apartments = Arrays.asList(apartment);
        when(apartmentRepository.findBySuburb("Central")).thenReturn(apartments);
        List<Apartment> result = apartmentService.findBySuburb("Central");
        assertEquals(1, result.size());
        verify(apartmentRepository).findBySuburb("Central");
    }

    @Test
    void testFindByRentalCostLessThan() {
        List<Apartment> apartments = Arrays.asList(apartment);
        when(apartmentRepository.findByRentalCostLessThan(5000.0)).thenReturn(apartments);
        List<Apartment> result = apartmentService.findByRentalCostLessThan(5000.0);
        assertEquals(1, result.size());
        verify(apartmentRepository).findByRentalCostLessThan(5000.0);
    }
}