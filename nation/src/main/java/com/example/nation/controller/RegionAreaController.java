package com.example.nation.controller;

import com.example.nation.entity.RegionArea;
import com.example.nation.service.RegionAreaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/region-areas")
public class RegionAreaController {

    private final RegionAreaService service;

    public RegionAreaController(RegionAreaService service) {
        this.service = service;
    }

    @GetMapping
    public List<RegionArea> getAll() {
        return service.getAllRegionAreas();
    }

    @GetMapping("/{id}")
    public RegionArea getById(@PathVariable Integer id) {
        return service.getRegionAreaById(id);
    }

    @PostMapping
    public RegionArea save(@RequestBody RegionArea regionArea) {
        return service.saveRegionArea(regionArea);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteRegionArea(id);
    }
}