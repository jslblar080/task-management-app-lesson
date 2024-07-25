package com.github.jslblar080.persistence.repository;

import com.github.jslblar080.persistence.model.ProjectWithCrudRepository;
import org.springframework.data.repository.CrudRepository;

// Spring Data JPA auto-generates the implementation at runtime
// There's no need to customize implementations of ProjectRepository
// CrudRepository interface contains simple persistence and data access methods such as save, saveAll, findAll, findById
public interface ProjectRepository extends CrudRepository<ProjectWithCrudRepository, Long> {
}
