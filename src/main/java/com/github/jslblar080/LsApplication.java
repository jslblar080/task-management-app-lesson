package com.github.jslblar080;

import com.github.jslblar080.config.PersistenceConfig;
import com.github.jslblar080.persistence.repository.ProjectRepository;
import com.github.jslblar080.service.ProjectService;
import com.github.jslblar080.service.impl.ProjectServiceImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class LsApplication {

    public static void main(String[] args) {

//        SpringApplication.run(LsApplication.class, args);

//        try (var context = new AnnotationConfigApplicationContext("com.github.jslblar080")) {
//            ProjectServiceImpl projectRepo = context.getBean(ProjectServiceImpl.class);
//            var testIds = new Long[]{50000L, 100000L, 200000L};
//            printTestIds(projectRepo, testIds);
//        }

        try (var context = new AnnotationConfigApplicationContext(PersistenceConfig.class)) {
            ProjectRepository projectRepo = context.getBean(ProjectRepository.class);
            var testIds = new Long[]{50000L, 100000L, 200000L};
            printTestIds(projectRepo, testIds);
        }
    }

    public static void printTestIds(ProjectService projectService, Long[] testIds) {
        for (Long testId : testIds) {
            projectService.findById(testId).ifPresent(testProject -> {
                System.out.println("Project ID: " + testProject.getId());
                System.out.println("Project name: " + testProject.getName());
                System.out.println("Date created: " + testProject.getDateCreated());
            });
        }
    }

    public static void printTestIds(ProjectRepository projectRepo, Long[] testIds) {
        for (Long testId : testIds) {
            projectRepo.findById(testId).ifPresent(testProject -> {
                System.out.println("Project ID: " + testProject.getId());
                System.out.println("Project name: " + testProject.getName());
                System.out.println("Date created: " + testProject.getDateCreated());
            });
        }
    }

    // Project ID: 100000
    // Project name: First test
    // Date created: 2024-06-17
}
