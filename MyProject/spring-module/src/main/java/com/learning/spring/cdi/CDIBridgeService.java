package com.learning.spring.cdi;
import com.learning.business.service.BusinessLogicService;
import com.learning.cdiBridgeRest.BeanManagerBridge;


import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Iterator;
import java.util.Set;


public class CDIBridgeService implements CDIBridge {

    BeanManager beanManager;

    public BeanManager getBeanManager () {
       if (null==beanManager){
           beanManager= BeanManagerBridge.getBeanManager();
       }
       return beanManager;
    }

    public Object getBeanReference(){
        BusinessLogicService businessLogic=null;
        if(beanManager==null){
            beanManager=getBeanManager();
        }
        Set<Bean<?>> beans = beanManager.getBeans(BusinessLogicService.class);
        Iterator<Bean<?>> iterator = beans.iterator();
        while (iterator.hasNext()){
            Bean<?> bean = iterator.next();
            businessLogic= (BusinessLogicService) beanManager.getReference(bean,BusinessLogicService.class,beanManager.createCreationalContext(bean));
            Set<Bean<?>> beansa = beanManager.getBeans(BusinessLogicService.class);

        }
        return businessLogic;
    }

    }
