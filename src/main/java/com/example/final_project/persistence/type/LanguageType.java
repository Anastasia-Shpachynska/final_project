package com.example.final_project.persistence.type;

import lombok.Getter;

@Getter
public enum LanguageType {

    ENG("Англійська"),
    UKR("Українська"),
    RUS("Російська");

    private final String language;

    LanguageType(String language) {
        this.language = language;
    }
}
