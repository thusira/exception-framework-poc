package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Sajitha on 8/11/16.
 */

@Component
public class ErrorResponseHandlerImpl implements ErrorResponseHandler{

    @Autowired
    private Environment environment;

@Override
    public ErrorResponse findErrorResponsebyException(Exception ex) {
    //System.out.println( environment);
    ErrorResponse errorResponse = new ErrorResponse();
    Resource resource = new ClassPathResource("/errorHandling.properties");
    try {
        Properties props = PropertiesLoaderUtils.loadProperties(resource);
        errorResponse.setErrorCode("710");
        errorResponse.setErrorDescription(props.getProperty("710"));
    } catch (IOException e) {
        e.printStackTrace();
    }





    return errorResponse;
    }
}
