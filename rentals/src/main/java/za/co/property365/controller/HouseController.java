package za.co.property365.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.property365.domain.House;
import za.co.property365.service.HouseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/house")
public class HouseController {

    private final HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @PostMapping
    public House save(@RequestBody House house) {
        return houseService.save(house);
    }

    @GetMapping("/{id}")
    public Optional<House> read(@PathVariable Integer id) {
        return houseService.read(id);
    }

    @PutMapping
    public House update(@RequestBody House house) {
        return houseService.update(house);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        houseService.delete(id);
    }

    @GetMapping
    public List<House> getAll() {
        return houseService.getAll();
    }

    @GetMapping("/suburb/{suburb}")
    public List<House> findBySuburb(@PathVariable String suburb) {
        return houseService.findBySuburb(suburb);
    }

    @GetMapping("/rentalCostLessThan/{cost}")
    public List<House> findByRentalCostLessThan(@PathVariable double cost) {
        return houseService.findByRentalCostLessThan(cost);
    }
}