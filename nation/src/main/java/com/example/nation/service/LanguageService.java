package com.example.nation.service;

import com.example.nation.entity.Language;
import com.example.nation.repository.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    private final LanguageRepository repository;

    public LanguageService(LanguageRepository repository) {
        this.repository = repository;
    }

    public List<Language> getAllLanguages() {
        return repository.findAll();
    }

    public Language getCountryLanguageById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Language saveCountry (Language language) {
        return repository.save(language);
    }

    public void deleteLanguage(Integer id) {
        repository.deleteById(id);
    }
}
