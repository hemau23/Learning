package com.learning.business.service;


import javax.ejb.Singleton;
import javax.ejb.Stateless;


@Singleton
public class BusinessLogicService {

    String name;
    public String run() {
        return "Completed Job";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
