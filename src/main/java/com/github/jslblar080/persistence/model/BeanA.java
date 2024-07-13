package com.github.jslblar080.persistence.model;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@Slf4j
public class BeanA {

    private String foo;

    @PostConstruct // executed after the bean is instantiated
    public void postConstruct() {
        log.info("@PostConstruct annotated method from BeanA is called.");
        log.info("value of the property foo is: {}", foo);
    }
}
