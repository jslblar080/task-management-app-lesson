package com.github.jslblar080.config;

import com.github.jslblar080.persistence.model.BeanA;
import com.github.jslblar080.persistence.model.BeanB;
import com.github.jslblar080.persistence.model.BeanC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

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
}
