package ru.ncallie.ToDo.Exceptions;

public class DataInUseException extends RuntimeException{

    public DataInUseException(String s) {
        super(s);
    }
}
