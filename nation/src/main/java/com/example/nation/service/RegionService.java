package com.example.nation.service;

import com.example.nation.entity.Region;
import com.example.nation.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    private final RegionRepository repository;

    public RegionService(RegionRepository repository) {
        this.repository = repository;
    }

    public List<Region> getAllRegions() {
        return repository.findAll();
    }

    public Region getRegionById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Region saveRegion (Region region) {
        return repository.save(region);
    }

    public void deleteRegion(Integer id) {
        repository.deleteById(id);
    }
}
