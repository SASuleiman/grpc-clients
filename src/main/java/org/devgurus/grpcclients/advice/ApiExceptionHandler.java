package org.devgurus.grpcclients.advice;

import lombok.extern.slf4j.Slf4j;
import org.devgurus.grpcclients.dto.ExceptionResponse;
import org.devgurus.grpcclients.exceptions.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ExceptionResponse> handleException(Exception ex) {
        String errorMsg = "Oops, an unexpected error occurred!";
        log.error(errorMsg, ex);
        return new ResponseEntity<ExceptionResponse>(new ExceptionResponse(errorMsg,ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ExceptionResponse> handleException(BadRequestException ex) {
        String errorMsg = "Bad Request!";
        log.error(errorMsg, ex);
        return new ResponseEntity<ExceptionResponse>(new ExceptionResponse(errorMsg,ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
