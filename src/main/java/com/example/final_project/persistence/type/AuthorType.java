package com.example.final_project.persistence.type;

import lombok.Getter;

@Getter
public enum AuthorType {

    ROBERTMARTIN("Robert Martin"),
    CHARLESSEVERANCE("Charles Severance"),
    ALANCOOPER("Alan Cooper"),
    CHARLESPETZOLD("Charles Petzold");

    private final String author;

    AuthorType(String author) {
        this.author = author;
    }
}
