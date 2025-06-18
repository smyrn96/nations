package com.example.nation.service;

import com.example.nation.entity.CountryLanguage;
import com.example.nation.entity.Language;
import com.example.nation.repository.CountryLanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryLanguageService {

    private final CountryLanguageRepository repository;

    public CountryLanguageService(CountryLanguageRepository repository) {
        this.repository = repository;
    }

    public List<CountryLanguage> getAllCountryLanguages() {
        return repository.findAll();
    }

    public CountryLanguage getCountryLanguageById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<Language> getLanguagesByCountryId(Integer countryId) {
        return repository.findByCountryId(countryId).stream()
                .map(CountryLanguage::getLanguage)
                .collect(Collectors.toList());
    }

    public CountryLanguage saveCountry (CountryLanguage countryLanguage) {
        return repository.save(countryLanguage);
    }

    public void deleteCountryLanguage(Integer id) {
        repository.deleteById(id);
    }
}
