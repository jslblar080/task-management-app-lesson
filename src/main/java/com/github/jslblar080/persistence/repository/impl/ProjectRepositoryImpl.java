package com.github.jslblar080.persistence.repository.impl;

import com.github.jslblar080.persistence.model.Project;
import com.github.jslblar080.persistence.repository.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

// map-based implementation of the repository interface
@Profile("dev")
@Repository //@Component // meta-annotation that can be applied to another annotation
public class ProjectRepositoryImpl implements ProjectRepository {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectRepositoryImpl.class);

    private final Map<Long, Project> projects = new ConcurrentHashMap<>();

    public ProjectRepositoryImpl() {
        save(new Project(100000L, "First test", LocalDate.now()));
    }

    @Override
    public Optional<Project> findById(Long id) {
        LOG.debug("Finding Project By Id {} using ProjectRepositoryImpl", id);
        return Optional.ofNullable(projects.get(id));
    }

    @Override
    public void save(Project project) {
        LOG.debug("Saving Project {} using ProjectRepositoryImpl", project);
        projects.put(project.getId(), project);
    }
}
