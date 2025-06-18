package com.example.nation.controller;

import com.example.nation.entity.CountryLanguage;
import com.example.nation.entity.Language;
import com.example.nation.service.CountryLanguageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country-languages")
public class CountryLanguageController {

    private final CountryLanguageService service;

    public CountryLanguageController(CountryLanguageService service) {
        this.service = service;
    }

    @GetMapping
    public List<CountryLanguage> getAll() {
        return service.getAllCountryLanguages();
    }

    @GetMapping("/{id}")
    public CountryLanguage getById(@PathVariable Integer id) {
        return service.getCountryLanguageById(id);
    }

    @GetMapping("/country/{countryId}")
    public List<Language> getLanguagesByCountry(@PathVariable Integer countryId) {
        return service.getLanguagesByCountryId(countryId);
    }

    @PostMapping
    public CountryLanguage save(@RequestBody CountryLanguage countryLanguage) {
        return service.saveCountry(countryLanguage);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteCountryLanguage(id);
    }
}