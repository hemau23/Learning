package com.learning.ejb.service;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.enterprise.inject.Default;


public interface HelloWord {
    public String sayHello();
}
