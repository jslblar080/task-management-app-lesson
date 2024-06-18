package com.github.jslblar080;

import com.github.jslblar080.config.PersistenceConfig;
import com.github.jslblar080.persistence.repository.ProjectRepository;
import com.github.jslblar080.service.ProjectService;
import com.github.jslblar080.service.impl.ProjectServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@ComponentScan(
//        excludeFilters = {@ComponentScan.Filter(
//                type = FilterType.CUSTOM,
//                classes = {TypeExcludeFilter.class}
//        ), @ComponentScan.Filter(
//                type = FilterType.CUSTOM,
//                classes = {AutoConfigurationExcludeFilter.class}
//        )}
//)
@SpringBootApplication(scanBasePackages = "com.github.jslblar080")
public class LsApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(LsApplication.class, args);
//        persistence.model.BeanA   : @PostConstruct annotated method from BeanA is called.
//        persistence.model.BeanB   : @PostConstruct annotated method from BeanB is called.
//        persistence.model.BeanB   : Custom initMethod from BeanB is called.

        try (var ctx = new AnnotationConfigApplicationContext("com.github.jslblar080")) {
//            persistence.model.BeanA   : @PostConstruct annotated method from BeanA is called.
//            persistence.model.BeanB   : @PostConstruct annotated method from BeanB is called.
//            persistence.model.BeanB   : Custom initMethod from BeanB is called.

            ProjectServiceImpl projectRepo = ctx.getBean(ProjectServiceImpl.class);
            var testIds = new Long[]{50000L, 100000L, 200000L};
            printTestIds(projectRepo, testIds);
//            Project ID: 100000
//            Project name: First test
//            Date created: 2024-06-18

//            persistence.model.BeanC   : @PreDestroy annotated method from BeanC is called.
//            persistence.model.BeanC   : Custom destroyMethod from BeanC is called.
        }

        try (var ctx = new AnnotationConfigApplicationContext(PersistenceConfig.class)) {
//            persistence.model.BeanA   : @PostConstruct annotated method from BeanA is called.
//            persistence.model.BeanB   : @PostConstruct annotated method from BeanB is called.
//            persistence.model.BeanB   : Custom initMethod from BeanB is called.

            ProjectRepository projectRepo = ctx.getBean(ProjectRepository.class);
            var testIds = new Long[]{50000L, 100000L, 200000L};
            printTestIds(projectRepo, testIds);
//            Project ID: 100000
//            Project name: First test
//            Date created: 2024-06-18

//            persistence.model.BeanC   : @PreDestroy annotated method from BeanC is called.
//            persistence.model.BeanC   : Custom destroyMethod from BeanC is called.
        }

        context.close();
//        persistence.model.BeanC   : @PreDestroy annotated method from BeanC is called.
//        persistence.model.BeanC   : Custom destroyMethod from BeanC is called.
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
}
