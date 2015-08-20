package com.learning.rest;


import com.learning.business.service.BusinessLogicService;
import com.learning.cdiBridgeRest.BeanManagerBridge;
import com.learning.ejb.service.HelloWord;

import java.io.InterruptedIOException;
import java.util.List;
import java.util.Set;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;


@Path("/users")
public class UserService {

	@Inject
	HelloWord helloWord;

	@Inject
	BusinessLogicService businessLogicService;

	@GET
	@Path("/query")
	public Response getUsers(@DefaultValue("1000") @QueryParam("from") String from,
			@DefaultValue("999")@QueryParam("to") int to,
			@DefaultValue("name") @QueryParam("orderBy") List<String> orderBy) throws NamingException {
		BeanManager beanManager = BeanManagerBridge.getBeanManager();
		return Response
				.status(200)
				.entity(helloWord.sayHello() + " getUsers is called, from : " + from + ", to : " + to
						+ ", orderBy" + orderBy.toString()).build();

	}
	
	/*@GET
	@Path("/query")
	public Response getUsers(@Context UriInfo info) {

		String from = info.getQueryParameters().getFirst("from");
		String to = info.getQueryParameters().getFirst("to");
		List<String> orderBy = info.getQueryParameters().get("orderBy");
		
		return Response
				.status(200)
				.entity("getUsers is called, from : " + from + ", to : " + to
						+ ", orderBy" + orderBy.toString()).build();

	}*/

}