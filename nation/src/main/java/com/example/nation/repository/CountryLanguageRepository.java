package com.example.nation.repository;

import com.example.nation.entity.CountryLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, Integer> {

    @Query("SELECT cl FROM CountryLanguage cl WHERE cl.country.countryId = :countryId")
    List<CountryLanguage> findByCountryId(@Param("countryId") Integer countryId);
}