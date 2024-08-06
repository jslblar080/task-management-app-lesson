package com.github.jslblar080.task_management_app_lesson;

import com.github.jslblar080.persistence.model.TaskEntity;
import com.github.jslblar080.persistence.repository.TaskRepository;
import com.github.jslblar080.task_management_app_lesson.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.util.List;

@SpringJUnitConfig(classes = TestConfig.class)
public class TaskRepositoryIntegrationTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void whenFindingProjectByNameMatches_thenOk() {
        TaskEntity task1 = new TaskEntity("Low Priority Task", "Low Priority Task", LocalDate.now(), LocalDate.now());
        TaskEntity task2 = new TaskEntity("Low Priority Task", "Low Priority Task", LocalDate.now(), LocalDate.now());
        TaskEntity task3 = new TaskEntity("High Priority Task", "High Priority Task", LocalDate.now(), LocalDate.now());
        TaskEntity task4 = new TaskEntity("High Priority Task", "High Priority Task", LocalDate.now(), LocalDate.now());

        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);
        taskRepository.save(task4);

        List<TaskEntity> retrievedTasks = taskRepository.findByNameMatches("High");
        retrievedTasks.forEach(System.out::println);
        /*
        TaskEntity(id=3, name=High Priority Task, description=High Priority Task, dateCreated=XXXX-XX-XX, dueDate=XXXX-XX-XX, status=null)
        TaskEntity(id=4, name=High Priority Task, description=High Priority Task, dateCreated=XXXX-XX-XX, dueDate=XXXX-XX-XX, status=null)
        */
        assert (retrievedTasks.size() == 2);
    }
}
