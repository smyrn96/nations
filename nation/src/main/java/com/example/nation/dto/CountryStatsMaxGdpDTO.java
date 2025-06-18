package com.example.nation.dto;

import java.math.BigDecimal;

public class CountryStatsMaxGdpDTO {

    private String name;
    private String countryCode3;
    private Integer year;
    private Long population;
    private BigDecimal gdp;

    public CountryStatsMaxGdpDTO(String name, String countryCode3, Integer year, Long population, BigDecimal gdp) {
        this.name = name;
        this.countryCode3 = countryCode3;
        this.year = year;
        this.population = population;
        this.gdp = gdp;
    }

}
