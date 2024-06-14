package com.github.jslblar080.persistence.repository;

import com.github.jslblar080.persistence.model.Project;

import java.util.Optional;

public interface ProjectRepository {

    Optional<Project> findById(Long id);

    void save(Project project);
}
