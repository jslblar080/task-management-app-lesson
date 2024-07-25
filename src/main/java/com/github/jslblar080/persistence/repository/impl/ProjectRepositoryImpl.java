package com.github.jslblar080.persistence.repository.impl;

import com.github.jslblar080.persistence.model.Project;
import com.github.jslblar080.persistence.repository.ProjectRepositoryWithoutCrudRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

// map-based implementation of the repository interface
@Slf4j
@Profile("dev")
@Repository //@Component // meta-annotation that can be applied to another annotation
public class ProjectRepositoryImpl implements ProjectRepositoryWithoutCrudRepository {

    private final Map<Long, Project> projects = new ConcurrentHashMap<>();

    public ProjectRepositoryImpl() {
        save(new Project(100000L, "First test", LocalDate.now()));
    }

    @Override
    public Optional<Project> findById(Long id) {
        log.debug("Finding Project By Id {} using ProjectRepositoryImpl", id);
        return Optional.ofNullable(projects.get(id));
    }

    @Override
    public Project save(Project project) {
        log.debug("Saving Project {} using ProjectRepositoryImpl", project);
        projects.put(project.getId(), project);
        return project;
    }
}
