package com.example.nation.controller;

import com.example.nation.dto.CountryRegionStatsView;
import com.example.nation.entity.CountryStats;
import com.example.nation.service.CountryStatsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country-stats")
public class CountryStatsController {

    private final CountryStatsService service;
    private final CountryStatsService countryStatsService;

    public CountryStatsController(CountryStatsService service, CountryStatsService countryStatsService) {
        this.service = service;
        this.countryStatsService = countryStatsService;
    }

    @GetMapping
    public List<CountryStats> getAll() {
        return service.getAllCountryStats();
    }

    @GetMapping("/{id}")
    public CountryStats getById(@PathVariable Integer id) {
        return service.getCountryStatsById(id);
    }

    @GetMapping("/max-gdp-per-capita")
    public List<CountryStats> getMaxGdpPerCapita() {
        return countryStatsService.getMaxGdpPerCapitaStats();
    }

    @GetMapping("/region-stats")
    public List<CountryRegionStatsView> getStatsView(
            @RequestParam(required = false) String region,
            @RequestParam(required = false) Integer from,
            @RequestParam(required = false) Integer to
    ) {
        return service.getCountryStatsView(region, from, to);
    }

    @PostMapping
    public CountryStats save(@RequestBody CountryStats countryStats) {
        return service.saveCountry(countryStats);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteCountryStats(id);
    }
}