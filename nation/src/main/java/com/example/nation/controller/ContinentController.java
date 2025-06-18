package com.example.nation.controller;

import com.example.nation.entity.Continent;
import com.example.nation.service.ContinentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/continents")
public class ContinentController {

    private final ContinentService service;

    public ContinentController(ContinentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Continent> getAll() {
        return service.getAllContinents();
    }

    @GetMapping("/{id}")
    public Continent getById(@PathVariable Integer id) {
        return service.getContinentById(id);
    }

    @PostMapping
    public Continent save(@RequestBody Continent continent) {
        return service.saveContinent(continent);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteContinent(id);
    }
}