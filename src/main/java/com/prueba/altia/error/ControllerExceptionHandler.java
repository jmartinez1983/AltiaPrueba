package com.prueba.altia.error;

import com.prueba.altia.model.Problem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.format.DateTimeParseException;

/**
 * Class to manage exceptions from ProductController
 */
@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    /**
     * Method to manage malformed exceptions of the request params
     *
     * @param ex Runtime exception
     * @param request Web request
     * @return Response Entity with the problem
     */
    @ExceptionHandler({IllegalStateException.class, IllegalArgumentException.class, DateTimeParseException.class})
    public ResponseEntity<Problem> malformedException(RuntimeException ex, WebRequest request) {
        Problem problem = new Problem();
        problem.setTitle("Malformed syntax of the request params");
        problem.setStatus(HttpStatus.BAD_REQUEST.value());
        problem.setDetail(ex.getMessage());
        log.error(request.getDescription(true), ex);
        return new ResponseEntity<Problem>(problem, HttpStatus.BAD_REQUEST);
    }

    /**
     * Method to manage global exceptions
     *
     * @param ex Exception class
     * @param request Web request
     * @return Response Entity with the problem
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Problem> globalExceptionHandler(Exception ex, WebRequest request) {
        Problem problem = new Problem();
        problem.setTitle("Server encountered an unespected problem");
        problem.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        problem.setDetail(ex.getMessage());
        log.error(request.getDescription(true), ex);
        return new ResponseEntity<Problem>(problem, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}