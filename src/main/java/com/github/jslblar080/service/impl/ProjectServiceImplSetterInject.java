package com.github.jslblar080.service.impl;

import com.github.jslblar080.persistence.model.Project;
import com.github.jslblar080.persistence.repository.ProjectRepositoryWithoutCrudRepository;
import com.github.jslblar080.service.ProjectService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Component // meta-annotation that can be applied to another annotation
@Service
@Lazy // Lazy initialization helps limit resource consumption peaks at startup and save overall system resources.
public class ProjectServiceImplSetterInject implements ProjectService {

    private ProjectRepositoryWithoutCrudRepository projectRepo;

    public ProjectServiceImplSetterInject() {
    }

    // setter-based dependency injection (annotation required for injecting dependencies)
    @Resource(name = "projectRepositoryImpl")
    public void setProjectRepository(ProjectRepositoryWithoutCrudRepository projectRepo) {
        this.projectRepo = projectRepo;
    }

    @Override
    public Optional<Project> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Project save(Project project) {
        return projectRepo.save(project);
    }
}
