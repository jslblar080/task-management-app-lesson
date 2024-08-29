package com.github.jslblar080.persistence.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@ToString
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private LocalDate dateCreated;

    @Setter
    private String internalId;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_entity_id")
    private final Set<TaskEntity> tasks = new HashSet<>();
}
