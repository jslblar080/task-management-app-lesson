package com.github.jslblar080.config;

import com.github.jslblar080.persistence.repository.impl.ProjectRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfig {

    @Bean
    public ProjectRepositoryImpl projectRepo() {
        return new ProjectRepositoryImpl();
    }
}
