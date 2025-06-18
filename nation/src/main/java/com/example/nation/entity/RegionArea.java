package com.example.nation.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "region_areas")
public class RegionArea {
    @Id
    @Column(name = "region_name", length = 100)
    private String regionName;

    @Column(name = "region_area", precision = 15, scale = 2)
    private BigDecimal regionArea;

    public RegionArea() {
    }

    public RegionArea(String regionName, BigDecimal regionArea) {
        this.regionName = regionName;
        this.regionArea = regionArea;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public BigDecimal getRegionArea() {
        return regionArea;
    }

    public void setRegionArea(BigDecimal regionArea) {
        this.regionArea = regionArea;
    }
}
