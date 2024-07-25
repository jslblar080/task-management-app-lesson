package com.github.jslblar080.config;

import com.github.jslblar080.persistence.repository.ProjectRepositoryWithoutCrudRepository;
import com.github.jslblar080.persistence.repository.impl.ProjectRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PersistenceConfig {

    @Bean
    //@Scope("singleton") or @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ProjectRepositoryWithoutCrudRepository singletonBean() {
        return new ProjectRepositoryImpl();
    }

    @Bean
    @Scope("prototype") // or @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ProjectRepositoryWithoutCrudRepository prototypeBean() {
        return new ProjectRepositoryImpl();
    }
}
