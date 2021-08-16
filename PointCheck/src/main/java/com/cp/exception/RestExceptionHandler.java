/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cp.exception;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;
import org.springframework.http.*;
import java.text.ParseException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ ParseException.class })
    protected ResponseEntity<Object> handleNotFound(
      Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Issue with date format", 
          new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
    @ExceptionHandler({ CustomerNullException.class })
    protected ResponseEntity<Object> handleNullCustomer(
      Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Customer is not found", 
          new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}