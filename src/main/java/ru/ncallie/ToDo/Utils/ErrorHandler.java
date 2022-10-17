package ru.ncallie.ToDo.Utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.ncallie.ToDo.Exceptions.DataInUseException;
import ru.ncallie.ToDo.Exceptions.InvalidActivationCodeException;
import ru.ncallie.ToDo.Exceptions.InvalidPasswordException;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(DataInUseException dataInUseException) {
        ErrorResponse response = ErrorResponse.builder().message(dataInUseException.getMessage()).timestamp(System.currentTimeMillis()).build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(UsernameNotFoundException usernameNotFoundException) {
        ErrorResponse response = ErrorResponse.builder().message(usernameNotFoundException.getMessage()).timestamp(System.currentTimeMillis()).build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(InvalidPasswordException invalidPasswordException) {
        ErrorResponse response = ErrorResponse.builder().message(invalidPasswordException.getMessage()).timestamp(System.currentTimeMillis()).build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(InvalidActivationCodeException invalidActivationCodeException) {
        ErrorResponse response = ErrorResponse.builder().message(invalidActivationCodeException.getMessage()).timestamp(System.currentTimeMillis()).build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
