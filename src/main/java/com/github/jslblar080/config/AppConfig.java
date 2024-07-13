package com.github.jslblar080.config;

import com.github.jslblar080.persistence.model.BeanA;
import com.github.jslblar080.persistence.model.BeanB;
import com.github.jslblar080.persistence.model.BeanC;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Slf4j
@Configuration
public class AppConfig {

    private final Environment env;

    // Environment interface is an abstraction integrated in the container
    // It can be used to get the application’s properties and the profile information
    public AppConfig(@Autowired Environment env) {
        this.env = env;
    }

    @Bean
    public BeanA beanA() {
        return new BeanA();
    }

    // Tasks with opening a file, opening a network/database connection, allocating memory
    @Bean(initMethod = "initialize")
    public BeanB beanB() {
        return new BeanB();
    }

    // Tasks with closing a file, closing a network/database connection, deallocating memory
    @Bean(destroyMethod = "destroy")
    public BeanC beanC() {
        return new BeanC();
    }

    @PostConstruct
    void post() {
        log.info("Active Profiles: {}", env.getActiveProfiles());
        log.info("Default Profiles: {}", env.getDefaultProfiles());
    }
}
