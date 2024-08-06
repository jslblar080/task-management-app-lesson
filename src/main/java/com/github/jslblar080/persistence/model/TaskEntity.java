package com.github.jslblar080.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
@ToString
@Entity
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // for h2 in-memory database
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String description;

    @NonNull
    private LocalDate dateCreated;

    @NonNull
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING) // avoid EnumType.ORDINAL
    private TaskStatus status;

    protected TaskEntity() {
    }
}
