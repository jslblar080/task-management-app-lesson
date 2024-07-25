package com.github.jslblar080.persistence.repository;

import com.github.jslblar080.persistence.model.Project;

import java.util.Optional;

public interface ProjectRepositoryWithoutCrudRepository {

    Optional<Project> findById(Long id);

    Project save(Project project);
}
