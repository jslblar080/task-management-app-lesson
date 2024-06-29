package com.github.jslblar080.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component // BeanFactoryPostProcessor is invoked even before the bean instantiation happens
           // First the BeanFactoryPostProcessor is invoked, followed by the BeanPostProcessor
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override // abstract method
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("postProcessBeanFactory is invoked!");
        // bean factory is used to obtain the BeanDefinition of beanA
        BeanDefinition bd = beanFactory.getBeanDefinition("beanA");
        // BeanDefinition object offers methods to read and modify the metadata of the bean
        bd.getPropertyValues().add("foo", "bar");
    }
}
