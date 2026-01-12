package za.co.property365.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.property365.domain.RentalAgent;
import za.co.property365.repository.RentalAgentRepository;

import java.util.List;

@Service
public class RentalAgentService implements IRentalAgentService {

    private final RentalAgentRepository rentalAgentRepository;

    @Autowired
    public RentalAgentService(RentalAgentRepository rentalAgentRepository) {
        this.rentalAgentRepository = rentalAgentRepository;
    }

    @Override
    public RentalAgent save(RentalAgent rentalAgent) {
        return rentalAgentRepository.save(rentalAgent);
    }

    @Override
    public RentalAgent read(Integer id) {
        return rentalAgentRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public RentalAgent update(RentalAgent rentalAgent) {
        return rentalAgentRepository.save(rentalAgent);
    }

    @Override
    public void deleteById(Integer id) {
        rentalAgentRepository.deleteById(id);
    }

    @Override
    public void delete(RentalAgent rentalAgent) {
        rentalAgentRepository.delete(rentalAgent);
    }

    @Override
    public List<RentalAgent> getAll() {
        return (List<RentalAgent>) rentalAgentRepository.findAll();
    }

    @Override
    public List<RentalAgent> findBySuburb(String suburb) {
        return rentalAgentRepository.findBySuburb(suburb);
    }

    @Override
    public List<RentalAgent> findByName(String name) {
        return rentalAgentRepository.findByName(name);
    }
}