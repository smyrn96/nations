package com.example.nation.service;

import com.example.nation.entity.Continent;
import com.example.nation.repository.ContinentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinentService {

    private final ContinentRepository repository;

    public ContinentService(ContinentRepository repository) {
        this.repository = repository;
    }

    public List<Continent> getAllContinents() {
        return repository.findAll();
    }

    public Continent getContinentById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Continent saveContinent(Continent continent) {
        return repository.save(continent);
    }

    public void deleteContinent(Integer id) {
        repository.deleteById(id);
    }
}
