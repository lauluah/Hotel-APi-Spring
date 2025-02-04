package com.hotelapi.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ClientNotFoundException.class})
    public ResponseEntity<Error> handleClientNotFoundException(ClientNotFoundException e) {
        Error Error = new Error();
        Error.setMensagem(e.getMessage());
        Error.setCodigoErro("USR-404");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Error);
    }
}
