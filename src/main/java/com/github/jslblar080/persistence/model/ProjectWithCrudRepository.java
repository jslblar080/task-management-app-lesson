package com.github.jslblar080.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Entity
public class ProjectWithCrudRepository {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate dateCreated;

    @Setter
    private String internalId;

    protected ProjectWithCrudRepository() {
    }

    public ProjectWithCrudRepository(String name, LocalDate dateCreated) {
        this.name = name;
        this.dateCreated = dateCreated;
    }
}
