package com.github.jslblar080.persistence.model;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanA {

    @PostConstruct
    public void postConstruct() {
        log.info("@PostConstruct annotated method from BeanA is called.");
    }
}
