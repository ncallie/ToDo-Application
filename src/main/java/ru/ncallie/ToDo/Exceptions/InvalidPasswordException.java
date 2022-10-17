package ru.ncallie.ToDo.Exceptions;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String s) {
        super(s);
    }
}
