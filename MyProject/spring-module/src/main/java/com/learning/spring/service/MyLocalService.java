package com.learning.spring.service;

import com.learning.business.service.BusinessLogicService;
import com.learning.business.service.SomeOtherLogicService;
import com.learning.spring.cdi.CDIInject;
import org.springframework.stereotype.Component;

@Component
public class MyLocalService {

    @CDIInject
    BusinessLogicService businessLogicService;

    public String say(){
        return businessLogicService.run();
    }
}
