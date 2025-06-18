package com.example.nation.repository;

import com.example.nation.entity.Vip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VipRepository extends JpaRepository<Vip, Integer> {

}