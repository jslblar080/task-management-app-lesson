package com.github.jslblar080.persistence.model;

import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanC {

    @PreDestroy // executed before the context that contains the bean is destroyed
    public void preDestroy() {
        log.info("@PreDestroy annotated method from BeanC is called.");
    }

    public void destroy() {
        log.info("Custom destroyMethod from BeanC is called.");
    }
}
