package com.learning.spring.controller;

import com.learning.spring.service.HelloWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Controller
public class HelloController {

	@Inject
	HelloWord helloWord;




	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Test");
		return "hello";

	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("test",name);
		model.addObject("msg", helloWord.sayHellow());

		InitialContext initialContext = null;
		try {
			initialContext = new InitialContext();
			BeanManager beanManager = (BeanManager) initialContext.lookup("java:comp/BeanManager");
			System.out.println("");
		} catch (NamingException e) {
			e.printStackTrace();
		}

		return model;

	}

}