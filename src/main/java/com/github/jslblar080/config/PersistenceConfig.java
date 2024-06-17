package com.github.jslblar080.config;

import com.github.jslblar080.persistence.repository.impl.ProjectRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.REGEX,
                        pattern = "com.github.jslblar080.persisitence.repository.*"
                )
        }
)
public class PersistenceConfig {

    @Bean
    public ProjectRepositoryImpl projectRepo() {
        return new ProjectRepositoryImpl();
    }
}
