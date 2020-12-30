package com.training.ykb.util;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handle(final IllegalArgumentException exp) {
        return new ErrorObj().setSubDomain("IT")
                             .setBoundedContext("ERP")
                             .setMicroservice("customer")
                             .setDesc(exp.getMessage())
                             .setCause(202)
                             .init();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handle(final MethodArgumentNotValidException exp) {
        ErrorObj rootError = new ErrorObj().setSubDomain("IT")
                                           .setBoundedContext("ERP")
                                           .setMicroservice("customer")
                                           .setDesc("Validation Error")
                                           .setCause(202)
                                           .init();
        List<ObjectError> allErrorsLoc = exp.getBindingResult()
                                            .getAllErrors();
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            rootError.addSubError(new ErrorObj().setSubDomain("IT")
                                                .setBoundedContext("ERP")
                                                .setMicroservice("customer")
                                                .setDesc(objectErrorLoc.toString())
                                                .setCause(333)
                                                .init());
        }
        return rootError;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> handle(final Exception exp) {
        ErrorObj err = new ErrorObj().setSubDomain("IT")
                                     .setBoundedContext("ERP")
                                     .setMicroservice("customer")
                                     .setDesc(exp.getMessage())
                                     .setCause(780)
                                     .init();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .header("err",
                                     "merr")
                             .body(err);
    }

}
