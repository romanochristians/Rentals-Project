package za.co.property365.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.property365.domain.House;
import za.co.property365.repository.HouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HouseService implements IHouseService {

    private final HouseRepository houseRepository;

    @Autowired
    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Override
    public House save(House house) {
        return houseRepository.save(house);
    }

    @Override
    public Optional<House> read(Integer id) {
        return houseRepository.findById(id);
    }

    @Override
    public House update(House house) {
        return houseRepository.save(house);
    }

    @Override
    public List<House> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Integer id) {
        houseRepository.deleteById(id);
    }

    @Override
    public List<House> getAll() {
        return (List<House>) houseRepository.findAll();
    }

    @Override
    public List<House> findBySuburb(String suburb) {
        return houseRepository.findBySuburb(suburb);
    }

    @Override
    public List<House> findByRentalCostLessThan(double maxRentalCost) {
        return houseRepository.findByRentalCostLessThan(maxRentalCost);
    }
    @Override
    public Optional<House> findById(Integer id) {
        return houseRepository.findById(id);
    }
}