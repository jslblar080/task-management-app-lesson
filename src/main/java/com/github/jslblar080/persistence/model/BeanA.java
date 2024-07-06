package com.github.jslblar080.persistence.model;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanA {

    private String foo;

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    @PostConstruct // executed after the bean is instantiated
    public void postConstruct() {
        log.info("@PostConstruct annotated method from BeanA is called.");
        log.info("value of the property foo is: {}", foo);
    }
}
