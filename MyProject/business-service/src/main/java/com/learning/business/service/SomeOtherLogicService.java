package com.learning.business.service;

import javax.ejb.Stateless;
import javax.inject.Inject;


public class SomeOtherLogicService implements SomeOtherLogic {

    @Inject
    TestForInject testForInject;
    public String someOtherLogic() {
        return testForInject.testForInject();
    }
}
