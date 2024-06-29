package com.github.jslblar080.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component // The container invokes the BeanPostProcessor for each and every bean.
           // First the BeanFactoryPostProcessor is invoked, followed by the BeanPostProcessor
public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        log.info("BeanPostProcessor implemented class is instantiated!");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //log.info("Before initializing the bean: {}", beanName);
        return bean; // before bean initialization
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //log.info("After initializing the bean: {}", beanName);
        return bean; // after bean initialization
    }
}