package com.github.jslblar080.persistence.model;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanB {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public void initialize() {
        log.info("Custom initMethod from BeanB is called.");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("@PostConstruct annotated method from BeanB is called.");
    }
}
