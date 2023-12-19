package com.example.final_project.persistence.type;

import lombok.Getter;

@Getter
public enum AuthorType {

    ROBERTMARTIN("Robert Martin"),
    JOANEROWLING("Joanne Rowling"),
    NAPOLEONGILL("Napoleon Gill");


    private final String author;

    AuthorType(String author) {
        this.author = author;
    }
}
