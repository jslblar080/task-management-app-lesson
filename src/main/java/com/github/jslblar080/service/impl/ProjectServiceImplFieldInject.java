package com.github.jslblar080.service.impl;

import com.github.jslblar080.persistence.model.Project;
import com.github.jslblar080.persistence.repository.ProjectRepository;
import com.github.jslblar080.service.ProjectService;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Component // meta-annotation that can be applied to another annotation
@Service
@Lazy // Lazy initialization helps limit resource consumption peaks at startup and save overall system resources.
public class ProjectServiceImplFieldInject implements ProjectService {

    // field-based dependency injection
    @Inject
    @Named("projectRepositoryImpl")
    private ProjectRepository projectRepo; // using @Autowired on fields is not the recommended practice

    public ProjectServiceImplFieldInject() {
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepo.findById(id);
    }

    @Override
    public void save(Project project) {
        projectRepo.save(project);
    }
}
