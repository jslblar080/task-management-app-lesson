package com.github.jslblar080.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Slf4j
@Component // The container invokes the BeanPostProcessor for each and every bean.
// First the BeanFactoryPostProcessor is invoked, followed by the BeanPostProcessor
public class FirstBeanPostProcessor implements BeanPostProcessor, Ordered {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("beanA")) {
            log.info("Before initializing the bean: {}", beanName);
        }
        return bean; // before bean initialization
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("beanA")) {
            log.info("After initializing the bean: {}", beanName);
        }
        return bean; // after bean initialization
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
