package com.bridgelabz.payroll.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException e){
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        StringBuilder errMsg = new StringBuilder();
        for(FieldError err : fieldErrors){
            errMsg.append(err.getField()).append(" ").append(err.getDefaultMessage()).append("; ");
        }
        ErrorResponse errRes = new ErrorResponse(errMsg.toString(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errRes, HttpStatus.BAD_REQUEST);
    }
    // employee not found exception
    @ExceptionHandler(EmployeeNotFoundException.class)
    public  ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException e){
        System.out.println("Exception Occured : "+e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
