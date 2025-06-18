package com.example.nation.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "continents")
public class Continent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer continentId;

    private String name;

    public Continent() {
    }

    public Continent(String name, Integer continentId) {
        this.name = name;
        this.continentId = continentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getContinentId() {
        return continentId;
    }

    public void setContinentId(Integer continentId) {
        this.continentId = continentId;
    }
}
