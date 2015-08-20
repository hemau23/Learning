package com.learning.spring.cdi;

import com.learning.cdiBridgeRest.BeanManagerBridge;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;

import javax.enterprise.context.spi.Contextual;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;


public class CDIBeanPostProcessor implements BeanPostProcessor {

    final static Logger loger= Logger.getLogger(CDIBridgeService.class);
    public static final int TIMEOUT = 60000;
    public static final int SLEEPTIME = 1000;
    private BeanManager beanManager;

    public void init(){
        if (null==beanManager){
            beanManager= BeanManagerBridge.getBeanManager();
            loger.info("Bean Manager from bridge initilized");
        }
        long startTime=System.currentTimeMillis();
        while (null==beanManager){
            try {
                beanManager = BeanManagerBridge.getBeanManager();
                Thread.sleep(SLEEPTIME);

                if ((System.currentTimeMillis()-startTime)> TIMEOUT){
                    loger.fatal("ERROR : TimeOut While initilzation  Bean manager after deployment");
                    break;
                }
            } catch (InterruptedException e) {
                loger.error("ERROR : While initilzation  Bean manager after deployment");
            }
        }
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        loger.info(beanName + "has been initialized");
        Class<?> clazz = bean.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields){
            if(field.isAnnotationPresent(CDIInject.class)){
                injectBeanField(bean, field);
            }
        }

        return bean;
    }

    private void injectBeanField(Object bean, Field field) {
        field.setAccessible(true);
        try {
            field.set(bean,getBeanReference(field.getType()));
        } catch (IllegalAccessException e) {
            loger.error("Not able to inject using CDIInject "+ e);
        }
    }

    public BeanManager getBeanManager() {
        return beanManager;
    }

    public Object getBeanReference(Class<?> type){

        loger.info(" Finding out reference for bean");
        Set<Bean<?>> beans = beanManager.getBeans(type);
        Iterator<Bean<?>> iterator = beans.iterator();
        while (iterator.hasNext()){
            Bean<?> bean = iterator.next();
            return this.beanManager.getReference(bean, type, this.beanManager.createCreationalContext(bean));
        }
        loger.error(type.getName()+" Bean not found.....");
        return null;
    }
}
