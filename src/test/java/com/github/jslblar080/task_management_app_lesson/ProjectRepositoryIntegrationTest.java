package com.github.jslblar080.task_management_app_lesson;

import com.github.jslblar080.persistence.model.ProjectWithCrudRepository;
import com.github.jslblar080.persistence.repository.ProjectRepository;
import com.github.jslblar080.task_management_app_lesson.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(classes = TestConfig.class)
public class ProjectRepositoryIntegrationTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    public void whenSavingProject_thenOk() {
        ProjectWithCrudRepository project = new ProjectWithCrudRepository("First test", LocalDate.now());
        assertNotNull(projectRepository.save(project));
    }

    @Test
    public void whenFindingProjectById_thenOk() {
        ProjectWithCrudRepository project = new ProjectWithCrudRepository("First test", LocalDate.now());
        projectRepository.save(project);
        Optional<ProjectWithCrudRepository> retrievedProject = projectRepository.findById(project.getId());
        assert (retrievedProject.isPresent());
        assert (retrievedProject.get().getName().equals(project.getName()));
    }
}
