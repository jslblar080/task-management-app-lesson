package com.github.jslblar080.persistence.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

@Getter
public class Project {

    private final Long id;

    private final String name;

    private final LocalDate dateCreated;

    @Setter
    private String internalId;

    public Project(Long id, String name, LocalDate dateCreated) {
        if (Objects.isNull(id)) {
            id = new Random().nextLong();
        }
        this.id = id;
        this.name = name;
        this.dateCreated = dateCreated;
    }
}
