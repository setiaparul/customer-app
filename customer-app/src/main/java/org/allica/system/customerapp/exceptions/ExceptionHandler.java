package org.allica.system.customerapp.exceptions;

import org.allica.system.customerapp.models.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.Objects;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(CustomerCreationFailureException.class)
    public ResponseEntity<ResponseDto<Object>> handleCustomerCreationFailureException(
            CustomerCreationFailureException e) {
        ResponseDto<Object> responseDto = new ResponseDto<>(
                null,
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }



    @org.springframework.web.bind.annotation.ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ResponseDto<String>> handleCustomerNotFoundException(
            CustomerNotFoundException e) {
        ResponseDto<String> responseDto = new ResponseDto<>(
                null,
                e.getMessage(),
                e.getStatusCode()
        );
        return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto<String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining("; "));

        ResponseDto<String> responseDto = new ResponseDto<>(
                null,
                errorMessage,
                400
        );
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }
}