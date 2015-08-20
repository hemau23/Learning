package com.learning.spring.config;

import com.learning.spring.cdi.CDIBeanPostProcessor;
import com.learning.spring.service.HelloWord;
import com.learning.spring.service.HelloWordService;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class AppConfig {

    @Bean
    InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver internalResourceViewResolver= new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/views/jsp/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    @Bean
    HelloWord helloWord(){
        return new HelloWordService();
    }

    @Bean
    BeanPostProcessor beanPostProcessor(){
        CDIBeanPostProcessor cdiBeanPostProcessor = new CDIBeanPostProcessor();
        cdiBeanPostProcessor.init();
        return  cdiBeanPostProcessor;
    }

}
