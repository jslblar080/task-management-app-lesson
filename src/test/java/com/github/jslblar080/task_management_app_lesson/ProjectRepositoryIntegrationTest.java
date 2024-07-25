package com.github.jslblar080.task_management_app_lesson;

import com.github.jslblar080.persistence.model.ProjectWithCrudRepository;
import com.github.jslblar080.persistence.repository.ProjectRepository;
import com.github.jslblar080.task_management_app_lesson.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        assertEquals(retrievedProject.get().getName(), project.getName());
    }

    @Test
    public void whenFindingProjectByName_thenOk() {
        ProjectWithCrudRepository project = new ProjectWithCrudRepository("First test", LocalDate.now());
        projectRepository.save(project);
        Optional<ProjectWithCrudRepository> retrievedProject = projectRepository.findByName(project.getName());
        assert (retrievedProject.isPresent());
        assertEquals(retrievedProject.get().getId(), project.getId());
    }

    @Test
    public void whenFindingProjectByDateCreatedBetween_thenOk() {
        ProjectWithCrudRepository oldProject = new ProjectWithCrudRepository("First test", LocalDate.now().minusYears(1));
        projectRepository.save(oldProject);

        ProjectWithCrudRepository newProject = new ProjectWithCrudRepository("Second test", LocalDate.now());
        projectRepository.save(newProject);

        ProjectWithCrudRepository newProject2 = new ProjectWithCrudRepository("Third test", LocalDate.now());
        projectRepository.save(newProject2);

        List<ProjectWithCrudRepository> retrievedProjects = projectRepository.findByDateCreatedBetween(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
        assert (retrievedProjects.size() == 2);
    }
}
