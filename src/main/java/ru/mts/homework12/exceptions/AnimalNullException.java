package ru.mts.homework12.exceptions;

public class AnimalNullException extends NullPointerException {

    public AnimalNullException() {
    }

    public AnimalNullException(String s) {
        super(s);
    }

}
