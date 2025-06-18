package com.example.nation.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer languageId;

    private String language;

    public Language() {
    }

    public Language(Integer languageId, String language) {
        this.languageId = languageId;
        this.language = language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public String getLanguage() {
        return language;
    }

    public Integer getLanguageId() {
        return languageId;
    }
}
