package com.github.jslblar080;

import com.github.jslblar080.service.impl.ProjectServiceImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class LsApplication {

    public static void main(String[] args) {

//        SpringApplication.run(LsApplication.class, args);
        try (var context = new AnnotationConfigApplicationContext("com.github.jslblar080")) {
            ProjectServiceImpl projectRepo = context.getBean(ProjectServiceImpl.class);
            var testIds = new Long[]{50000L, 100000L, 200000L};

            for (Long testId : testIds) {
                projectRepo.findById(testId).ifPresent(testProject -> {
                    System.out.println("Project ID: " + testProject.getId()); // Project ID: 100000
                    System.out.println("Project name: " + testProject.getName()); // Project name: First test
                    System.out.println("Date created: " + testProject.getDateCreated()); // Date created: 2024-06-15
                });
            }
        }
    }
}
