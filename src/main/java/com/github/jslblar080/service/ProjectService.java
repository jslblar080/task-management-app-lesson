package com.github.jslblar080.service;

import com.github.jslblar080.persistence.model.Project;

import java.util.Optional;

public interface ProjectService {

    Optional<Project> findById(Long id);

    void save(Project project);
}
