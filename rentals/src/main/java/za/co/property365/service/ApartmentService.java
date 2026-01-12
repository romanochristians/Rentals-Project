package za.co.property365.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.property365.domain.Apartment;
import za.co.property365.repository.ApartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ApartmentService implements IApartmentService {

    private final ApartmentRepository apartmentRepository;

    @Autowired
    public ApartmentService(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }
    @Override
    public Apartment save(Apartment apartment) {
        return apartmentRepository.save(apartment);
    }
    @Override
    public Optional<Apartment> findById(Integer id) {
        return apartmentRepository.findById(id);
    }
    @Override
    public Apartment update(Apartment apartment) {
        return apartmentRepository.save(apartment);
    }

    @Override
    public List<Apartment> findAll() {
        return (List<Apartment>) apartmentRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        apartmentRepository.deleteById(id);
    }
    @Override
    public List<Apartment> getAll() {
        return (List<Apartment>) apartmentRepository.findAll();
    }

    @Override
    public List<Apartment> findBySuburb(String suburb) {
        return apartmentRepository.findBySuburb(suburb);
    }

    @Override
    public List<Apartment> findByRentalCostLessThan(double maxRentalCost) {
        return apartmentRepository.findByRentalCostLessThan(maxRentalCost);
    }
}

