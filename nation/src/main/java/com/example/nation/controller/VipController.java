package com.example.nation.controller;

import com.example.nation.entity.Vip;
import com.example.nation.service.VipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vips")
public class VipController {

    private final VipService service;

    public VipController(VipService service) {
        this.service = service;
    }

    @GetMapping
    public List<Vip> getAll() {
        return service.getAllVip();
    }

    @GetMapping("/{id}")
    public Vip getById(@PathVariable Integer id) {
        return service.getVipById(id);
    }

    @PostMapping
    public Vip save(@RequestBody Vip vip) {
        return service.saveVip(vip);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteVip(id);
    }
}