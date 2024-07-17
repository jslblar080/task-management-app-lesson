package com.github.jslblar080.task_management_app_lesson;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
class ContextIntegrationTest {

    @Autowired
    private ApplicationContext applicationContext;

    // Testing if Spring context is bootstrapping, which is not always guaranteed

    @Test
    public void whenContextIsLoaded_thenNoExceptions() {
        System.out.println(applicationContext.getId());
    }

    @Test
    public void whenContextIsLoaded_thenNoExceptions2() {
        // application context is cached between tests by test framework
        System.out.println(applicationContext.getId());
    }

}
