package com.github.jslblar080.persistence.model;

import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanC {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @PreDestroy
    public void preDestroy() {
        log.info("@PreDestroy annotated method from BeanC is called.");
    }

    public void destroy() {
        log.info("Custom destroyMethod from BeanC is called.");
    }
}
