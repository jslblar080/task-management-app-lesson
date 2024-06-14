package com.github.jslblar080.persistence.repository.impl;

import com.github.jslblar080.persistence.model.Project;
import com.github.jslblar080.persistence.repository.ProjectRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

// map-based implementation of the repository interface
@Component("projectRepo") // bean instance id
public class ProjectRepositoryImpl implements ProjectRepository {

    private final Map<Long, Project> projects = new ConcurrentHashMap<>();

    public ProjectRepositoryImpl() {
        save(new Project(100000L, "First test", LocalDate.now()));
    }

    @Override
    public Optional<Project> findById(Long id) {
        return Optional.ofNullable(projects.get(id));
    }

    @Override
    public void save(Project project) {
        projects.put(project.getId(), project);
    }
}
