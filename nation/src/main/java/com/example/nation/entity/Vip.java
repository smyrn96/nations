package com.example.nation.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "vips")
public class Vip {

    @Id
    @Column(name = "vip_id")
    private Integer vipId;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    public Vip() {
    }

    public Vip(Integer vipId, String name) {
        this.vipId = vipId;
        this.name = name;
    }

    public Integer getVipId() {
        return vipId;
    }

    public void setVipId(Integer vipId) {
        this.vipId = vipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}