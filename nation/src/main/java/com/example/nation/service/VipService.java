package com.example.nation.service;

import com.example.nation.entity.Vip;
import com.example.nation.repository.VipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VipService {

    private final VipRepository repository;

    public VipService(VipRepository repository) {
        this.repository = repository;
    }

    public List<Vip> getAllVip() {
        return repository.findAll();
    }

    public Vip getVipById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Vip saveVip (Vip vip) {
        return repository.save(vip);
    }

    public void deleteVip(Integer id) {
        repository.deleteById(id);
    }
}
