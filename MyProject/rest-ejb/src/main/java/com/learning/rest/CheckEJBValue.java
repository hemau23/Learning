package com.learning.rest;

import com.learning.business.service.BusinessLogicService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/users")
public class CheckEJBValue {
    @Inject
    BusinessLogicService businessLogicService;

    @GET
    @Path("/check")
    public String print(){
        return  businessLogicService.getName();
    }


}
