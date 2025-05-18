package com.sonnesen.productsapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = { NotFoundException.class })
    protected ProblemDetail handleNotFound(RuntimeException ex, WebRequest request) {
        final var problem = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problem.setTitle("Not Found");
        problem.setDetail(ex.getMessage());
        return problem;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        final var invalidFields = e.getBindingResult()
                                   .getFieldErrors()
                                   .stream()
                                   .map(field -> new InvalidField(field.getField(), field.getDefaultMessage()))
                                   .toList();
        final var problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problem.setTitle("Bad Request");
        problem.setDetail("Invalid fields");
        problem.setProperty ("invalidFields", invalidFields);
        return problem;
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleRuntimeException(final Exception e) {
        final var problem = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problem.setTitle("Internal Server Error");
        problem.setDetail(e.getMessage());
        return problem;
    }

    private record InvalidField(String field, String message) {}
}
