package com.github.jslblar080.service.impl;

import com.github.jslblar080.persistence.model.Project;
import com.github.jslblar080.persistence.repository.ProjectRepository;
import com.github.jslblar080.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Component // meta-annotation that can be applied to another annotation
@Service // bean name: projectServiceImpl registered in IoC container
@Lazy // delay the creation of a bean up until the point it's required (lazy initialization)
public class ProjectServiceImpl implements ProjectService {

    @Autowired // Spring autowires POJO field with the projectRepo bean (ProjectRepositoryImpl)
    private ProjectRepository projectRepo; // using @Autowired on fields is not the recommended practice

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepo.findById(id);
    }

    @Override
    public void save(Project project) {
        projectRepo.save(project);
    }
}
