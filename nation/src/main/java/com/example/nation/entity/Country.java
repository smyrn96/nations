package com.example.nation.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer countryId;

    private String name;
    private BigDecimal area;
    @Column(columnDefinition = "DATE")
    private LocalDate nationalDay;

    @Column(columnDefinition = "CHAR(2)", nullable = false, unique = true)
    private String countryCode2;

    @Column(columnDefinition = "CHAR(3)", nullable = false, unique = true)
    private String countryCode3;

    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    public Country() {
    }

    public Country(Integer countryId, String name, BigDecimal area, LocalDate nationalDay, String countryCode2, String countryCode3, Region region) {
        this.countryId = countryId;
        this.name = name;
        this.area = area;
        this.nationalDay = nationalDay;
        this.countryCode2 = countryCode2;
        this.countryCode3 = countryCode3;
        this.region = region;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public String getCountryCode3() {
        return countryCode3;
    }

    public void setCountryCode3(String countryCode3) {
        this.countryCode3 = countryCode3;
    }

    public LocalDate getNationalDay() {
        return nationalDay;
    }

    public void setNationalDay(LocalDate nationalDay) {
        this.nationalDay = nationalDay;
    }

    public String getCountryCode2() {
        return countryCode2;
    }

    public void setCountryCode2(String countryCode2) {
        this.countryCode2 = countryCode2;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
