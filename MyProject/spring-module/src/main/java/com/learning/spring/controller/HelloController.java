package com.learning.spring.controller;

import com.learning.business.service.BusinessLogic;
import com.learning.business.service.BusinessLogicService;
import com.learning.spring.cdi.CDIBeanPostProcessor;
import com.learning.spring.cdi.CDIBridgeService;
import com.learning.spring.cdi.CDIInject;
import com.learning.spring.service.HelloWord;
import com.learning.spring.service.MyLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Iterator;
import java.util.Set;

@Controller
public class HelloController {

	@Inject
	HelloWord helloWord;

	@Inject
	CDIBeanPostProcessor cdiBeanPostProcessor;
	@Inject
	MyLocalService myLocalService;

	@CDIInject
	BusinessLogicService businessLogicService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Test");
		return "hello";

	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("test", name);
		model.addObject("msg", helloWord.sayHellow());
		businessLogicService.getName();
		businessLogicService.run();
		myLocalService.say();
		return model;
	}

}
