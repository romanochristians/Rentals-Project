package za.co.property365.service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import za.co.property365.domain.House;
import za.co.property365.repository.HouseRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HouseServiceTest {

    @Mock
    private HouseRepository houseRepository;

    @InjectMocks
    private HouseService houseService;

    private House house;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        house = new House.Builder()
                .streetNumber("123")
                .streetName("Main St")
                .suburb("Suburbia")
                .city("Metropolis")
                .postalCode(12345)
                .rentalCost(1500.00)
                .erfSize(500)
                .build();
    }

    @Test
    void testSave() {
        when(houseRepository.save(house)).thenReturn(house);
        House saved = houseService.save(house);
        assertNotNull(saved);
        assertEquals(house, saved);
        verify(houseRepository).save(house);
    }

    @Test
    void testRead() {
        when(houseRepository.findById(1)).thenReturn(Optional.of(house));
        Optional<House> found = houseService.read(1);
        assertTrue(found.isPresent());
        assertEquals(house, found.get());
        verify(houseRepository).findById(1);
    }

    @Test
    void testUpdate() {
        when(houseRepository.save(house)).thenReturn(house);
        House updated = houseService.update(house);
        assertNotNull(updated);
        assertEquals(house, updated);
        verify(houseRepository).save(house);
    }

    @Test
    void testDelete() {
        doNothing().when(houseRepository).deleteById(1);
        houseService.delete(1);
        verify(houseRepository).deleteById(1);
    }

    @Test
    void testGetAll() {
        List<House> houses = Arrays.asList(house);
        when(houseRepository.findAll()).thenReturn(houses);
        List<House> result = houseService.getAll();
        assertEquals(1, result.size());
        verify(houseRepository).findAll();
    }

    @Test
    void testFindBySuburb() {
        List<House> houses = Arrays.asList(house);
        when(houseRepository.findBySuburb("Suburbia")).thenReturn(houses);
        List<House> result = houseService.findBySuburb("Suburbia");
        assertEquals(1, result.size());
        verify(houseRepository).findBySuburb("Suburbia");
    }

    @Test
    void testFindByRentalCostLessThan() {
        List<House> houses = Arrays.asList(house);
        when(houseRepository.findByRentalCostLessThan(2000.0)).thenReturn(houses);
        List<House> result = houseService.findByRentalCostLessThan(2000.0);
        assertEquals(1, result.size());
        verify(houseRepository).findByRentalCostLessThan(2000.0);
    }

    @Test
    void testFindById() {
        when(houseRepository.findById(1)).thenReturn(Optional.of(house));
        Optional<House> found = houseService.findById(1);
        assertTrue(found.isPresent());
        assertEquals(house, found.get());
        verify(houseRepository).findById(1);
    }
}