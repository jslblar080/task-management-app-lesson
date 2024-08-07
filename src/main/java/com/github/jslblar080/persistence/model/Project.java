package com.github.jslblar080.persistence.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

@Getter
public class Project {

    private Long id;

    private String name;

    private LocalDate dateCreated;

    @Setter
    private String internalId;

    protected Project() {
    }

    public Project(Long id, String name, LocalDate dateCreated) {
        if (Objects.isNull(id)) {
            id = new Random().nextLong();
        }
        this.id = id;
        this.name = name;
        this.dateCreated = dateCreated;
    }
}
