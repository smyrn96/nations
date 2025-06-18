package com.example.nation.service;

import com.example.nation.dto.CountryStatsMaxGdpDTO;
import com.example.nation.entity.CountryStats;
import com.example.nation.repository.CountryStatsRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryStatsService {

    private final CountryStatsRepository repository;

    public CountryStatsService(CountryStatsRepository repository) {
        this.repository = repository;
    }

    public List<CountryStats> getAllCountryStats() {
        return repository.findAll();
    }

    public CountryStats getCountryStatsById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<CountryStats> getMaxGdpPerCapitaStats() {
        return repository.findMaxGdpPerCapitaStats();
    }

    public CountryStats saveCountry (CountryStats countryStats) {
        return repository.save(countryStats);
    }

    public void deleteCountryStats(Integer id) {
        repository.deleteById(id);
    }
}
