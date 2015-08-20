package com.learning.spring.cdi;
import com.learning.cdiBridgeRest.BeanManagerBridge;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

import java.util.Iterator;
import java.util.Set;


public class CDIBridgeService implements CDIBridge {
    final static Logger logger = Logger.getLogger(CDIBridgeService.class);

    BeanManager beanManager;

    @Inject
    CDIBeanPostProcessor cdiBeanPostProcessor;

    public Object getBeanReference(Class<?> type){

        logger.info(" Finding out reference for bean");
        BeanManager beanManager = cdiBeanPostProcessor.getBeanManager();
        Set<Bean<?>> beans = beanManager.getBeans(type);
        Iterator<Bean<?>> iterator = beans.iterator();
        while (iterator.hasNext()){
            Bean<?> bean = iterator.next();
            return this.beanManager.getReference(bean, type, this.beanManager.createCreationalContext(bean));
        }
        logger.error(type.getName()+" Bean not found.....");
        return null;
    }

    }
