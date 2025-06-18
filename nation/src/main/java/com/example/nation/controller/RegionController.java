package com.example.nation.controller;

import com.example.nation.entity.Region;
import com.example.nation.service.RegionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

    private final RegionService service;

    public RegionController(RegionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Region> getAll() {
        return service.getAllRegions();
    }

    @GetMapping("/{id}")
    public Region getById(@PathVariable Integer id) {
        return service.getRegionById(id);
    }

    @PostMapping
    public Region save(@RequestBody Region region) {
        return service.saveRegion(region);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteRegion(id);
    }
}