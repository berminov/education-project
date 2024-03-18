package ru.mts.homework11.exceptions;

public class AnimalNullException extends NullPointerException {

    public AnimalNullException() {
    }

    public AnimalNullException(String s) {
        super(s);
    }
}
