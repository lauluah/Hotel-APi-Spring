package com.hotelapi.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleGlobalException(Exception e) {
        Error error = new Error();
        error.setMensagem("Ocorreu um erro inesperado.");
        error.setCodigoErro("GEN-500");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler({ClientNotFoundException.class})
    public ResponseEntity<Error> handleClientNotFoundException(ClientNotFoundException e) {
        Error Error = new Error();
        Error.setMensagem(e.getMessage());
        Error.setCodigoErro("USR-404");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Error);
    }

    @ExceptionHandler({CpfNotFoundException.class})
    public ResponseEntity<Error> handleCpfNotFoundException(CpfNotFoundException e) {
        Error Error = new Error();
        Error.setMensagem(e.getMessage());
        Error.setCodigoErro("USR-409");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Error);
    }

    @ExceptionHandler({CpfAlreadyExistsException.class})
    public ResponseEntity<Error> handleCpfAlreadyExistsException(CpfAlreadyExistsException e) {
        Error Error = new Error();
        Error.setMensagem(e.getMessage());
        Error.setCodigoErro("USR-409");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Error);
    }

}
