package com.github.jslblar080.task_management_app_lesson;

import com.github.jslblar080.persistence.model.ProjectEntity;
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
        ProjectEntity project = new ProjectEntity("First test", LocalDate.now());
        assertNotNull(projectRepository.save(project));
    }

    @Test
    public void whenFindingProjectById_thenOk() {
        ProjectEntity project = new ProjectEntity("First test", LocalDate.now());
        projectRepository.save(project);
        Optional<ProjectEntity> retrievedProject = projectRepository.findById(project.getId());
        assert (retrievedProject.isPresent());
        assertEquals(retrievedProject.get().getName(), project.getName());
    }

    @Test
    public void whenFindingProjectByName_thenOk() {
        ProjectEntity project = new ProjectEntity("First test", LocalDate.now());
        projectRepository.save(project);
        Optional<ProjectEntity> retrievedProject = projectRepository.findByName(project.getName());
        assert (retrievedProject.isPresent());
        assertEquals(retrievedProject.get().getId(), project.getId());
    }

    @Test
    public void whenFindingProjectByDateCreatedBetween_thenOk() {
        ProjectEntity oldProject = new ProjectEntity("First test", LocalDate.now().minusYears(1));
        projectRepository.save(oldProject);

        ProjectEntity newProject = new ProjectEntity("Second test", LocalDate.now());
        projectRepository.save(newProject);

        ProjectEntity newProject2 = new ProjectEntity("Third test", LocalDate.now());
        projectRepository.save(newProject2);

        List<ProjectEntity> retrievedProjects = projectRepository.findByDateCreatedBetween(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
        assert (retrievedProjects.size() == 2);
    }
}
