package com.github.jslblar080.persistence.model;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanA {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @PostConstruct
    public void postConstruct() {
        log.info("@PostConstruct annotated method from BeanA is called.");
    }
}
