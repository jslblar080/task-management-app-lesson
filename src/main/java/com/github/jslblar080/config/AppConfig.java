package com.github.jslblar080.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jslblar080.persistence.model.BeanA;
import com.github.jslblar080.persistence.model.BeanB;
import com.github.jslblar080.persistence.model.BeanC;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Slf4j
@PropertySource("classpath:additional.properties")
@Configuration
public class AppConfig {

    private final Environment env;

    private final String additional;

    // Environment interface is an abstraction integrated in the container
    // It can be used to get the application’s properties and the profile information
    public AppConfig(
            @Autowired Environment env,
            @Value("${additional.info}") String additional
    ) {
        this.env = env;
        this.additional = additional;
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

    // default ObjectMapper is based on @ConditionalOnMissingBean (only executable with Positive matches when not customized)
    /*
    Negative matches:

    JacksonAutoConfiguration.JacksonObjectMapperConfiguration#jacksonObjectMapper:
      Did not match:
         - @ConditionalOnMissingBean (types: com.fasterxml.jackson.databind.ObjectMapper; SearchStrategy: all) found beans of type 'com.fasterxml.jackson.databind.ObjectMapper' objectMapper (OnBeanCondition)
    */
    // customized ObjectMapper like below is executed
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @PostConstruct
    public void post() {
        log.info("Active Profiles: {}", env.getActiveProfiles());
        log.info("Default Profiles: {}", env.getDefaultProfiles());
    }

    @PostConstruct
    public void showAdditionalProperty() {
        log.info("Additional property: {}", additional);
    }
}
