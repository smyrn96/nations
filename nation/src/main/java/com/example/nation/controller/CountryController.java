package com.example.nation.controller;

import com.example.nation.entity.Country;
import com.example.nation.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Country> getAll() {
        return service.getAllCountries();
    }

    @GetMapping("/{id}")
    public Country getById(@PathVariable Integer id) {
        return service.getCountryById(id);
    }

    @PostMapping
    public Country save(@RequestBody Country country) {
        return service.saveCountry(country);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteCountry(id);
    }
}