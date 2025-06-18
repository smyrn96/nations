package com.example.nation.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "regions")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer regionId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "continent_id")
    private Continent continent;

    public Region() {
    }

    public Region(Integer regionId, String name, Continent continent) {
        this.regionId = regionId;
        this.name = name;
        this.continent = continent;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }
}
