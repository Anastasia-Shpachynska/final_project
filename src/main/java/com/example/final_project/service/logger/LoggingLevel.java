package com.example.final_project.service.logger;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LoggingLevel {

    INFO("info"),
    ERROR("error");

    private final String level;
}
