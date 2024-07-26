package com.github.jslblar080.persistence.repository;

import com.github.jslblar080.persistence.model.ProjectEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

// Spring Data JPA auto-generates the implementation at runtime
// There's no need to customize implementations of ProjectRepository
// CrudRepository interface contains simple persistence and data access methods such as save, saveAll, findAll, findById
public interface ProjectRepository extends CrudRepository<ProjectEntity, Long> {

    // Even for custom query methods, there's no need to write implementation

    // Optional return type for the unique project with specific name
    Optional<ProjectEntity> findByName(String name);

    // List return type for multiple projects that fit this style of criteria
    List<ProjectEntity> findByDateCreatedBetween(LocalDate from, LocalDate to);

    List<ProjectEntity> findByDateCreatedLessThan(LocalDate from);

    List<ProjectEntity> findByDateCreatedGreaterThan(LocalDate to);
}
