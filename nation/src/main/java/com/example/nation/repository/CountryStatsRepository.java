package com.example.nation.repository;

import com.example.nation.dto.CountryRegionStatsView;
import com.example.nation.entity.CountryStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryStatsRepository extends JpaRepository<CountryStats, Integer> {

    @Query(value = """
    SELECT cs.*
    FROM country_stats cs
    JOIN countries c ON cs.country_id = c.country_id
    WHERE (cs.country_id, cs.gdp / cs.population) IN (
        SELECT
            cs2.country_id,
            MAX(cs2.gdp / cs2.population)
        FROM country_stats cs2
        GROUP BY cs2.country_id
    )
""", nativeQuery = true)
    List<CountryStats> findMaxGdpPerCapitaStats();

    @Query("""
    SELECT new com.example.nation.dto.CountryRegionStatsView(
        c.region.continent.name,
        c.region.name,
        c.name,
        cs.year,
        cs.population,
        cs.gdp
    )
    FROM CountryStats cs
    JOIN cs.country c
""")
    List<CountryRegionStatsView> getCountryRegionStatsView();

}