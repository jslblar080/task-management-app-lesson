package com.github.jslblar080.persistence.repository.impl;

import com.github.jslblar080.persistence.model.Project;
import com.github.jslblar080.persistence.repository.ProjectRepositoryWithoutCrudRepository;
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
public class ProjectRepositoryPropertyInject implements ProjectRepositoryWithoutCrudRepository {

    /*
    왜 프로퍼티가 아닌 생성자의 파라미터에 @Value를 적용하였는지?

    [프로퍼티에 @Value를 적용하는 경우]
    application.properties에서 logging.level.org.springframework=DEBUG로 설정해 확인해보면
    Creating shared instance of singleton bean 'projectRepositoryPropertyInject' 로그가 상단에서 최초로 찍히고
    하단에서 같은 내용의 로그가 한번 더 찍힌 후에야 Found key 'xxx' in PropertySource 로그가 찍히기 때문에
    즉, 처음에 singleton bean을 만들 때 곧 바로 프로퍼티의 외부 설정이 이루어지지 않는 경우가 있기 때문에 null로 반환된다.

    [생성자의 파라미터에 @Value를 적용하면]
    Creating shared instance of singleton bean 'projectRepositoryPropertyInject' 로그가 상단에서 최초로 찍히고
    곧 바로 Found key 'xxx' in PropertySource 로그가 찍히기 때문에 프로퍼티의 외부 설정이 정상적으로 이루어진다.
    */
    private final String prefix;

    private final Integer suffix;

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
    public Project save(Project project) {
        updateInternalId(project);
        projects.put(project.getId(), project);
        return project;
    }

    private void updateInternalId(Project project) {
        project.setInternalId(prefix + "-" + project.getId() + "-" + suffix);
    }
}
