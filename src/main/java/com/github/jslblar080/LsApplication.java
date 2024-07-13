package com.github.jslblar080;

import com.github.jslblar080.config.PersistenceConfig;
import com.github.jslblar080.persistence.repository.ProjectRepository;
import com.github.jslblar080.persistence.repository.impl.ProjectRepositoryImpl2;
import com.github.jslblar080.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
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
@SpringBootApplication //(scanBasePackages = "com.github.jslblar080")
@Slf4j
public class LsApplication {

    public static void main(String[] args) {

//        config.MyBeanFactoryPostProcessor  : postProcessBeanFactory is invoked!

        ConfigurableApplicationContext context = SpringApplication.run(LsApplication.class, args);
//        config.MyBeanPostProcessor         : Before initializing the bean: beanA
//        config.CustomBeanPostProcessor     : Before initializing the bean: beanA
//        persistence.model.BeanA   : @PostConstruct annotated method from BeanA is called.
//        persistence.model.BeanA   : value of the property foo is: bar
//        config.MyBeanPostProcessor         : After initializing the bean: beanA
//        config.CustomBeanPostProcessor     : After initializing the bean: beanA
//        persistence.model.BeanB   : @PostConstruct annotated method from BeanB is called.
//        persistence.model.BeanB   : Custom initMethod from BeanB is called.

        try (var ctx = new AnnotationConfigApplicationContext("com.github.jslblar080")) {
//            config.MyBeanFactoryPostProcessor  : postProcessBeanFactory is invoked!

//            config.MyBeanPostProcessor         : Before initializing the bean: beanA
//            config.CustomBeanPostProcessor     : Before initializing the bean: beanA
//            persistence.model.BeanA   : @PostConstruct annotated method from BeanA is called.
//            persistence.model.BeanA   : value of the property foo is: bar
//            config.MyBeanPostProcessor         : After initializing the bean: beanA
//            config.CustomBeanPostProcessor     : After initializing the bean: beanA
//            persistence.model.BeanB   : @PostConstruct annotated method from BeanB is called.
//            persistence.model.BeanB   : Custom initMethod from BeanB is called.

            log.info(ctx.getId());
            // org.springframework.context.annotation.AnnotationConfigApplicationContext@XXXXXXXX

            ProjectService projectService = ctx.getBean(ProjectService.class);
//            ProjectServiceImplConstructorInject : CONTEXT WITH ID 'org.springframework.context.annotation.AnnotationConfigApplicationContext@XXXXXXXX' SET
            var testIds = new Long[]{50000L, 100000L, 200000L};
            printTestIds(projectService, testIds);
//            Project ID: 100000
//            Project name: First test
//            Date created: 2024-06-18

            var projectRepositoryImpl2 = (ProjectRepositoryImpl2) ctx.getBean("projectRepositoryImpl2");
            projectRepositoryImpl2.findById(100000L).ifPresent(project -> log.info(project.getInternalId()));
//            LsApplication      : PRO-100000-123

//            persistence.model.BeanC   : @PreDestroy annotated method from BeanC is called.
//            persistence.model.BeanC   : Custom destroyMethod from BeanC is called.
        }

        try (var ctx = new AnnotationConfigApplicationContext(PersistenceConfig.class)) {
            var singletonRepo1 = (ProjectRepository) ctx.getBean("singletonBean");
            var singletonRepo2 = (ProjectRepository) ctx.getBean("singletonBean");
            if (singletonRepo1.toString().equals(singletonRepo2.toString())) {
                System.out.println("\nSame instance for singletonRepo1 and singletonRepo2.\n");
                // Same instance for singletonRepo1 and singletonRepo2.
            }
            var testIds = new Long[]{50000L, 100000L, 200000L};
            printTestIds(singletonRepo1, testIds);
//            Project ID: 100000
//            Project name: First test
//            Date created: 2024-06-18

            var prototypeRepo1 = (ProjectRepository) ctx.getBean("prototypeBean");
            var prototypeRepo2 = (ProjectRepository) ctx.getBean("prototypeBean");
            if (!prototypeRepo1.toString().equals(prototypeRepo2.toString())) {
                System.out.println("\nDifferent instance for prototypeRepo1 and prototypeRepo2.\n");
                // Different instance for prototypeRepo1 and prototypeRepo2.
            }
        }

        log.info("Context active before close: {}", context.isActive());
//        LsApplication      : Context active before close: true

        context.close();
//        persistence.model.BeanC   : @PreDestroy annotated method from BeanC is called.
//        persistence.model.BeanC   : Custom destroyMethod from BeanC is called.

        log.info("Context active after close: {}", context.isActive());
//        LsApplication      : Context active after close: false
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
