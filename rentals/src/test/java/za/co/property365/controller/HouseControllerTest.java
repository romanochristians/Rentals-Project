package za.co.property365.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import za.co.property365.domain.House;
import za.co.property365.service.HouseService;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HouseController.class)
public class HouseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HouseService houseService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testSave() throws Exception {
        House house = new House();
        Mockito.when(houseService.save(any(House.class))).thenReturn(house);

        mockMvc.perform(post("/api/house")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(house)))
                .andExpect(status().isOk());
    }

    @Test
    void testRead() throws Exception {
        House house = new House();
        Mockito.when(houseService.read(eq(1))).thenReturn(Optional.of(house));

        mockMvc.perform(get("/api/house/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdate() throws Exception {
        House house = new House();
        Mockito.when(houseService.update(any(House.class))).thenReturn(house);

        mockMvc.perform(put("/api/house")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(house)))
                .andExpect(status().isOk());
    }

    @Test
    void testDelete() throws Exception {
        mockMvc.perform(delete("/api/house/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAll() throws Exception {
        Mockito.when(houseService.getAll()).thenReturn(Arrays.asList(new House(), new House()));

        mockMvc.perform(get("/api/house"))
                .andExpect(status().isOk());
    }

    @Test
    void testFindBySuburb() throws Exception {
        Mockito.when(houseService.findBySuburb("Central")).thenReturn(Arrays.asList(new House()));

        mockMvc.perform(get("/api/house/suburb/Central"))
                .andExpect(status().isOk());
    }

    @Test
    void testFindByRentalCostLessThan() throws Exception {
        Mockito.when(houseService.findByRentalCostLessThan(5000.0)).thenReturn(Arrays.asList(new House()));

        mockMvc.perform(get("/api/house/rentalCostLessThan/5000.0"))
                .andExpect(status().isOk());
    }
}