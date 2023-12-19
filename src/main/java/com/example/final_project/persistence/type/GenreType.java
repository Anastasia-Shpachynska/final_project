package com.example.final_project.persistence.type;

import lombok.Getter;

@Getter
public enum GenreType {

    FOREIGNLANGUAGE("Книги іноземними мовами"),
    COMPUTERLITERATURE("Комп'ютерна література"),
    CHILDRENSLITERATURE("Дитяча література"),
    FANTASY("Фентезі"),
    FOREIGNLANGUAGES("Книги іноземними мовами"),
    SELFDEVELOPMENT("Саморозвиток"),
    BUSINESS("Бізнес");

    private final String genre;
    GenreType(String genre) {
        this.genre = genre;
    }
}
