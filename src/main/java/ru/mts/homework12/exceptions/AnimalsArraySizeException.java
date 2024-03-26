package ru.mts.homework12.exceptions;

public class AnimalsArraySizeException extends Exception {

    public AnimalsArraySizeException() {
    }

    public AnimalsArraySizeException(String message) {
        super(message);
    }

    public AnimalsArraySizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AnimalsArraySizeException(Throwable cause) {
        super(cause);
    }

    public AnimalsArraySizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
