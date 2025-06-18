package com.example.nation.service;

import com.example.nation.entity.RegionArea;
import com.example.nation.repository.RegionAreaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionAreaService {

    private final RegionAreaRepository repository;

    public RegionAreaService(RegionAreaRepository repository) {
        this.repository = repository;
    }

    public List<RegionArea> getAllRegionAreas() {
        return repository.findAll();
    }

    public RegionArea getRegionAreaById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public RegionArea saveRegionArea (RegionArea regionArea) {
        return repository.save(regionArea);
    }

    public void deleteRegionArea(Integer id) {
        repository.deleteById(id);
    }
}
