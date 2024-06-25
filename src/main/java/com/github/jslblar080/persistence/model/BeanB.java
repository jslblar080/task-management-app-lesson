package com.github.jslblar080.persistence.model;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanB {

    public void initialize() {
        log.info("Custom initMethod from BeanB is called.");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("@PostConstruct annotated method from BeanB is called.");
    }
}
