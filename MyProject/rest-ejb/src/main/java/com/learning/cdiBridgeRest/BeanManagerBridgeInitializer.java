package com.learning.cdiBridgeRest;



import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton //Note only use Singleton when you require a @Startup bean
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Startup
public class BeanManagerBridgeInitializer {

    @PostConstruct
    public void startup(){
       BeanManagerBridge.getBeanManager();
    }
}
