package com.inditex.pricing.infrastructure.exception;

import com.inditex.pricing.application.exception.TariffNotFoundException;
import com.inditex.pricing.domain.exception.ValidationException;
import com.inditex.pricing.infrastructure.userinterface.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class PricingControllerAdvice {
    private static final String STATUS = "error";

    @ExceptionHandler(ValidationException.class)
    private static ResponseEntity<ErrorResponse> validationException(ValidationException e) {
        ErrorResponse err = new ErrorResponse(STATUS, e.getMessage());

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TariffNotFoundException.class)
    private static ResponseEntity<ErrorResponse> tariffNotFound(TariffNotFoundException e) {
        ErrorResponse err = new ErrorResponse(STATUS, e.getMessage());

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    private static ResponseEntity<ErrorResponse> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        ErrorResponse err = new ErrorResponse(STATUS, e.getMessage());

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    private static ResponseEntity<ErrorResponse> noResourceFoundException(NoResourceFoundException e) {
        ErrorResponse err = new ErrorResponse(STATUS, e.getMessage());

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    private static ResponseEntity<ErrorResponse> missingServletRequestParameterException(MissingServletRequestParameterException e) {
        ErrorResponse err = new ErrorResponse(STATUS, e.getMessage());

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
}
