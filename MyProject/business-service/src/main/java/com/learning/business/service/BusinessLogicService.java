package com.learning.business.service;


import javax.ejb.Singleton;
import javax.ejb.Stateless;


@Stateless
public class BusinessLogicService extends SomeOtherLogicService {

    String name;
    public String run() {
        return this.someOtherLogic();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
