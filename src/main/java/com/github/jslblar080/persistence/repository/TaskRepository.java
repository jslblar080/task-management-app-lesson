package com.github.jslblar080.persistence.repository;

import com.github.jslblar080.persistence.model.TaskEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<TaskEntity, Long> {

    @Query("select t from TaskEntity t where t.name like %?1%")
    List<TaskEntity> findByNameMatches(String name);
}
