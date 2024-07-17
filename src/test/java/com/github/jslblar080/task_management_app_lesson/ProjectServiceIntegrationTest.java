package com.github.jslblar080.task_management_app_lesson;

import com.github.jslblar080.persistence.model.Project;
import com.github.jslblar080.service.ProjectService;
import com.github.jslblar080.task_management_app_lesson.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(classes = TestConfig.class)
public class ProjectServiceIntegrationTest {

    @Autowired
    private ProjectService projectService; // component scanning required

    @Test
    public void whenSavingProject_thenOk() {
        projectService.save(new Project(100000L, "First test", LocalDate.now()));
        assertNotNull(projectService);
    }
}
