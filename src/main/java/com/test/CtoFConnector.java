package com.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.ws.rs.*;

@Configurable
@Path("/ctofservice")
public class CtoFConnector {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ErrorResponseHandler errorResponseHandler;

    @GET
    @Path("/")
    @Produces("application/json")
    public String convertCtoF() {
        Double fahrenheit;
        Double celsius = 36.8;
        fahrenheit = ((celsius * 9) / 5) + 32;

        String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + fahrenheit;
        return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";
    }

    @Path("/{c}")
    @GET
    @Produces("application/xml")
    public String convertCtoFfromInput(@PathParam("c") Double c) {
        Double fahrenheit;
        Double celsius = c;
        fahrenheit = ((celsius * 9) / 5) + 32;
        String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + fahrenheit;
        return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";
    }

    /*@GET
    @Path("/emp")
    @Produces("application/json")
    public EmployeeBean getEmployee() {
        return employeeService.createEmployee();
    }*/
    @GET
    @Path("/emp")
    @Produces("application/json")
    public EmployeeBean getEmployee()  throws Exception{

            throw new NullPointerException("710");

        //return employeeService.createEmployee();
    }
}

