package com.dariojolo.zaratest.app.exceptions;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class})
    @ResponseBody
    public ErrorMessage notFoundRequest(HttpServletRequest request, Exception exception){
        return ErrorMessage.builder().exception(exception.getClass().getSimpleName()).message(exception.getMessage()).path(request.getRequestURI()).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BadRequestException.class})
    @ResponseBody
    public ErrorMessage badRequestException(HttpServletRequest request, Exception exception){
        return ErrorMessage.builder().exception(exception.getClass().getSimpleName()).message(exception.getMessage()).path(request.getRequestURI()).build();
    }
}
