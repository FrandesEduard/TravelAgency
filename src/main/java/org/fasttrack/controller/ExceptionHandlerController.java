package org.fasttrack.controller;

import org.fasttrack.exception.ApiException;
import org.fasttrack.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiException handleNotFound(EntityNotFoundException e) {
        return new ApiException(e.getMessage(), e.getEntityId(), HttpStatus.NOT_FOUND);
    }
}
