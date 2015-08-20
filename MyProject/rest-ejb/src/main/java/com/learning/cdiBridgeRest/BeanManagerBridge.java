package com.learning.cdiBridgeRest;

import org.apache.log4j.Logger;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class BeanManagerBridge {
    final static Logger logger = Logger.getLogger(BeanManagerBridge.class);
    private static BeanManager beanManager;

    public static BeanManager getBeanManager() {
        if (null == beanManager) initialiseBeanManager();
        return beanManager;
    }

    private static void initialiseBeanManager() {
        try {
            InitialContext initialContext = new InitialContext();
            beanManager = (BeanManager) initialContext.lookup("java:comp/BeanManager");
            logger.info("Bean Manager initialised successfully");
        } catch (NamingException e) {
            logger.error("Bean Manager not able to initialised");
        }
    }
}
