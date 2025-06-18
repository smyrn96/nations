package com.example.nation.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "country_languages")
@IdClass(CountryLanguage.class)
public class CountryLanguage {

    @Id
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Id
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    private boolean official;

    public CountryLanguage(){}

    public CountryLanguage(Country country, Language language, boolean official) {
        this.country = country;
        this.language = language;
        this.official = official;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public boolean isOfficial() {
        return official;
    }

    public void setOfficial(boolean official) {
        this.official = official;
    }
}
