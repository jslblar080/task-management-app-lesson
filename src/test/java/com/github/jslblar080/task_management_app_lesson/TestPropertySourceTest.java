package com.github.jslblar080.task_management_app_lesson;

import com.github.jslblar080.task_management_app_lesson.config.TestConfig;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig
@TestPropertySource("classpath:test.properties")
public class TestPropertySourceTest {

    private final String testproperty;

    private final String additional;

    public TestPropertySourceTest(
            @Value("${testproperty}") String testproperty,
            @Value("${additional.info}") String additional
    ) {
        this.testproperty = testproperty;
        this.additional = additional;
    }

    @Test
    public void whenTestPropertySource_thenValuesRetrieved() {
        assertEquals("Test Property Value", testproperty);
    }

    @Test
    @Disabled("Added only as an intermediate step for understanding, to make this run - comment additional.info from test.properties")
    public void whenPropertyDefinedInMain_thenValuesRetrieved() {
        assertEquals("Additional Info", additional);
    }

    @Test
    public void givenSameProperty_whenTestPropertySource_thenHigherPriority() {
        assertEquals("Additional Info From Test", additional);
    }
}
