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
@Profile("prod")
@Repository //@Component // meta-annotation that can be applied to another annotation
public class ProjectRepositoryDBBasedImpl implements ProjectRepositoryWithoutCrudRepository {

    private final Map<Long, Project> projects = new ConcurrentHashMap<>();

    public ProjectRepositoryDBBasedImpl() {
        save(new Project(100000L, "First test", LocalDate.now()));
    }

    @Override
    public Optional<Project> findById(Long id) {
        log.debug("Retrieving Project using ProjectRepositoryDBBasedImpl");
        return Optional.ofNullable(projects.get(id));
    }

    @Override
    public Project save(Project project) {
        projects.put(project.getId(), project);
        return project;
    }
}
