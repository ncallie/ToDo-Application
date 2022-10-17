package ru.ncallie.ToDo.Exceptions;

public class InvalidActivationCodeException extends RuntimeException{
    public InvalidActivationCodeException(String s) {
        super(s);
    }
}
