package ru.mts.homework11.exceptions;

public class AgeException extends IllegalArgumentException{
    public AgeException() {
    }

    public AgeException(String s) {
        super(s);
    }

    public AgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AgeException(Throwable cause) {
        super(cause);
    }
}
