package com.github.jslblar080.persistence.repository.impl;

import com.github.jslblar080.persistence.model.Project;
import com.github.jslblar080.persistence.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository //@Component // meta-annotation that can be applied to another annotation
@PropertySource("classpath:application.properties")
// map-based implementation of the repository interface
public class ProjectRepositoryPropertyInject implements ProjectRepository {

    // 왜 프로퍼티가 아닌 생성자의 파라미터에 @Value를 적용하였는지?
    // https://stackoverflow.com/questions/53482633/value-in-springboot-returns-null
    private String prefix;

    private Integer suffix;

    private final Map<Long, Project> projects = new ConcurrentHashMap<>();

    public ProjectRepositoryPropertyInject(
            @Value("${project.prefix}") String prefix,
            @Value("${project.suffix}") Integer suffix
    ) {
        this.prefix = prefix;
        this.suffix = suffix;
        save(new Project(100000L, "First test", LocalDate.now()));
    }

    @Override
    public Optional<Project> findById(Long id) {
        return Optional.ofNullable(projects.get(id));
    }

    @Override
    public void save(Project project) {
        updateInternalId(project);
        projects.put(project.getId(), project);
    }

    private void updateInternalId(Project project) {
        project.setInternalId(prefix + "-" + project.getId() + "-" + suffix);
    }
}
