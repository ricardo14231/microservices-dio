package com.dio.microservices.productcatalog.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ElementNotFoundException.class)
    protected ResponseEntity<ExceptionDetails> handleElementNotFound(ElementNotFoundException exception) {
        return new ResponseEntity<>(
                ExceptionDetails
                        .builder()
                        .title(exception.getMessage())
                        .status(HttpStatus.NOT_FOUND.value())
                        .details("Item não encontrado.")
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }
}
