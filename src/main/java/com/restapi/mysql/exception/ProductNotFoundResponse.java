package com.restapi.mysql.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductNotFoundResponse {

    @ResponseBody // this annotation says that the message of the exception is basically the web response that should be rendered to the user
    @ExceptionHandler(ProductNotFoundException.class) // this declares this method as one which handles exceptions
    @ResponseStatus(HttpStatus.NOT_FOUND) // When this exception handler is hit and a response is returned to the user
    String productNotFoundHandler(ProductNotFoundException exception) {
        return exception.getMessage();
    }
}
