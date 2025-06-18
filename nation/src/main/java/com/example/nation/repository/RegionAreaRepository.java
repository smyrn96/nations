package com.example.nation.repository;

import com.example.nation.entity.RegionArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionAreaRepository extends JpaRepository<RegionArea, Integer> {

}