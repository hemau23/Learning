package com.learning.ejb.service;
import javax.ejb.Stateless;

@Stateless
public class HelloWordService implements HelloWord {

    public HelloWordService(){}
    public String sayHello() {
        return "Hey Hello";
    }
}
