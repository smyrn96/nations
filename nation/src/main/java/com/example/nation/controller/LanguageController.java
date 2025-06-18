package com.example.nation.controller;

import com.example.nation.entity.Language;
import com.example.nation.service.LanguageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

    private final LanguageService service;

    public LanguageController(LanguageService service) {
        this.service = service;
    }

    @GetMapping
    public List<Language> getAll() {
        return service.getAllLanguages();
    }

    @GetMapping("/{id}")
    public Language getById(@PathVariable Integer id) {
        return service.getCountryLanguageById(id);
    }

    @PostMapping
    public Language save(@RequestBody Language country) {
        return service.saveCountry(country);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteLanguage(id);
    }
}