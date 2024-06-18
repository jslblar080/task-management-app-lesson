package com.github.jslblar080.persistence.model;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanA {

    private static Logger log = LoggerFactory.getLogger(BeanA.class);

    @PostConstruct
    public void postConstruct() {
        log.info("@PostConstruct annotated method from BeanA is called.");
    }
}
