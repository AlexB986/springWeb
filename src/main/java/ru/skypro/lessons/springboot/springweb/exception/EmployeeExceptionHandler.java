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
    public ResponseEntity<?> handleIOException(IOException ioException) {
        // Возвращает статус 404 (Not Found) при возникновении IOException.
        String message = "Нет такого id";

        return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleSQLException(SQLException sqlException) {
        // Возвращает статус 500 (Internal Server Error)
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception exception) {
        // Возвращает статус 403 (Forbidden) при возникновении Exception.
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
