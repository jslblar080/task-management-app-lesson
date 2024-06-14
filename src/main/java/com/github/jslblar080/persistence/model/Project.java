package com.github.jslblar080.persistence.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class Project {

    private final Long id;
    private final String name;
    private final LocalDate dateCreated;

    public Project(Long id, String name, LocalDate dateCreated) {
        if (Objects.isNull(id)) {
            id = new Random().nextLong();
        }
        this.id = id;
        this.name = name;
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }
}
