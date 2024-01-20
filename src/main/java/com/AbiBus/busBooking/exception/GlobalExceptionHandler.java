package com.AbiBus.busBooking.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                        WebRequest webRequest){
        ErrorDetails errorDetails=new ErrorDetails(
            LocalDateTime.now(),
            exception.getMessage(),
            webRequest.getDescription(false),
            "USER_NOT_FOUND"
            );


        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);


    }




    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> exception(Exception exception,WebRequest webRequest){

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "INTERNAL_SERVER-ERROR"
        );

        return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(BusException.class)
    public ResponseEntity<ErrorDetails> busException(BusException busEx,WebRequest web) {

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                busEx.getMessage(),
                web.getDescription(false),
                "BAD_REQUEST");

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }


    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String,String> errors=new HashMap<>();
        List<ObjectError> objectErrorList=ex.getBindingResult().getAllErrors();

        objectErrorList.forEach(objectError -> {
            FieldError fieldError=(FieldError)objectError;
            String field=fieldError.getField();
            String error=objectError.getDefaultMessage();

            errors.put(field,error);

        });

        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }




}
