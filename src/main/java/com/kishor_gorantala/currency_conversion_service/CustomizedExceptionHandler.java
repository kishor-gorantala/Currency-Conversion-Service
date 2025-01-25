package com.kishor_gorantala.currency_conversion_service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionEntity> HandleGenericException(Exception ex, WebRequest request) throws Exception{

        ExceptionEntity exceptionEntity = new ExceptionEntity(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity<ExceptionEntity>(exceptionEntity, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    }
