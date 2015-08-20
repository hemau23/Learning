package com.learning.cdiBridge;

import com.learning.business.service.BusinessLogicService;

import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class BeanManagerBridge {

    private static BeanManager beanManager;

    public static BeanManager getBeanManager() {
        if (null == beanManager) initialiseBeanManager();
        return beanManager;
    }

    private static void initialiseBeanManager() {
        try {
            InitialContext initialContext = new InitialContext();
            beanManager = (BeanManager) initialContext.lookup("java:comp/BeanManager");
        } catch (NamingException e) {
            System.out.println("[ERROR] Bean Manager not able to initialised");
        }
    }
}
