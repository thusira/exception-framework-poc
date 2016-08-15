package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sajitha on 8/9/16.
 */
//@Configuration
//@PropertySource("classpath:/properties/errorHandling.properties")
    @Configurable
public class CorsFilter extends OncePerRequestFilter {
    @Autowired
    private ErrorResponseHandler errorResponseHandler;

    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //httpServletResponse.setStatus(518);
        //httpServletResponse.setHeader("error","GET");

        try {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }catch (NullPointerException ex){
            //ResourceBundle rb = ResourceBundle.getBundle("properties/errorHandling");
            //String ervalue = rb.getString(ex.getMessage());
            //String ervalue = env.getProperty(ex.getMessage());
            //httpServletResponse.sendError(Integer.parseInt(ex.getMessage()),ervalue);
            //System.out.println(ex);
            ErrorResponse errorResponse = errorResponseHandler.findErrorResponsebyException(ex);
        }
        catch (Exception ex) {



            //httpServletResponse.setStatus(700);
            //httpServletResponse.setContentType("application/text");
            //httpServletResponse.setCharacterEncoding("UTF-8");
            //httpServletResponse.sendError(700,"Testing error");
            //httpServletResponse.getWriter().write("<html><head><title>Oops an error happened!</title></head>");
            //httpServletResponse.getWriter().write("<body>Something bad happened uh-oh!</body>");
            //httpServletResponse.getWriter().println("</html>");
            //ResourceBundle rb = ResourceBundle.getBundle("prolperties/errorHandling");
            //String ervalue = rb.getString(ex.getMessage());
            //String ervalue = env.getProperty("710");
            //httpServletResponse.sendError(Integer.parseInt(ex.getMessage().split(":")[1].trim()),ervalue);
            //System.out.println(ex);
            ErrorResponse errorResponse = errorResponseHandler.findErrorResponsebyException(ex);
            httpServletResponse.sendError(Integer.parseInt(errorResponse.getErrorCode()),errorResponse.getErrorDescription());
            System.out.println();
        }
    }
}
