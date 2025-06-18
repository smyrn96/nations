package com.example.nation.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "country_stats")
@IdClass(CountryStats.class)
public class CountryStats {

    @Id
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Id
    private Integer year;

    private Integer population;
    private BigDecimal gdp;

    public CountryStats() {
    }

    public CountryStats(Country country, Integer year, Integer population, BigDecimal gdp) {
        this.country = country;
        this.year = year;
        this.population = population;
        this.gdp = gdp;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public BigDecimal getGdp() {
        return gdp;
    }

    public void setGdp(BigDecimal gdp) {
        this.gdp = gdp;
    }
}
