package com.fmc.maidcorp.exception;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {ApiRequestException.class, ChangeSetPersister.NotFoundException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException apiRequestException){
      //Created payload that the client will see when an exception occors
        // TODO: 2023/06/16  
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ApiException apiException = new ApiException(
                apiRequestException.getMessage(),
                apiRequestException,
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))

        );
        return new ResponseEntity<>(apiException, badRequest);
    }

}
