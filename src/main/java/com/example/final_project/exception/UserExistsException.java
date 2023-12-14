package com.example.final_project.exception;

public class UserExistsException extends RuntimeException {

    public UserExistsException(String msg) {
        super(msg);
    }
}
