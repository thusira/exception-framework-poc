package com.test;

/**
 * Created by Sajitha on 8/11/16.
 */
public interface ErrorResponseHandler {

    ErrorResponse findErrorResponsebyException(Exception ex);
}
