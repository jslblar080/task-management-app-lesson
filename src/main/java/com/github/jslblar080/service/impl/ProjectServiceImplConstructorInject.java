package com.github.jslblar080.service.impl;

import com.github.jslblar080.persistence.model.Project;
import com.github.jslblar080.persistence.repository.ProjectRepository;
import com.github.jslblar080.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Component // meta-annotation that can be applied to another annotation
@Service
@Lazy // Lazy initialization helps limit resource consumption peaks at startup and save overall system resources.
@Primary // resolve autowire ambiguity when multiple beans are compatible to same type
@Slf4j
public class ProjectServiceImplConstructorInject implements ProjectService, ApplicationContextAware {

    private ProjectRepository projectRepo; // using @Autowired on fields is not the recommended practice

    public ProjectServiceImplConstructorInject() {
    }

    // constructor-based dependency injection
    @Autowired // multiple constructors need @Autowired (@Autowired is optional for a single constructor)
    public ProjectServiceImplConstructorInject(ProjectRepository singletonBean) {
        projectRepo = singletonBean;
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepo.findById(id);
    }

    @Override
    public void save(Project project) {
        projectRepo.save(project);
    }

    @Override // this method gives access to the current ApplicationContext
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("CONTEXT WITH ID '{}' SET", applicationContext.getId());
    }
}
