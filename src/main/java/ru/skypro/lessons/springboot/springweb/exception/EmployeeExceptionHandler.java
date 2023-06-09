package ru.skypro.lessons.springboot.springweb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.sql.SQLException;

@RestControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleSQLException(SQLException sqlException) {
        // Возвращает статус 500 (Internal Server Error)
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception exception) {
        // Возвращает статус 403 (Forbidden) при возникновении Exception.
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
