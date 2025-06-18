package com.example.nation.service;

import com.example.nation.entity.Country;
import com.example.nation.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository repository;

    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    public List<Country> getAllCountries() {
        return repository.findAll();
    }

    public Country getCountryById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Country saveCountry (Country country) {
        return repository.save(country);
    }

    public void deleteCountry(Integer id) {
        repository.deleteById(id);
    }
}
