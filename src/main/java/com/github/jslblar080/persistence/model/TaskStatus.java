package com.github.jslblar080.persistence.model;

import lombok.Getter;

@Getter
public enum TaskStatus {
    TO_DO("To Do"),
    IN_PROGRESS("In Progress"),
    ON_HOLD("On Hold"),
    DONE("Done");

    private final String label;

    TaskStatus(String label) {
        this.label = label;
    }
}
