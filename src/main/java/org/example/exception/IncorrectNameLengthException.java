package org.example.exception;

public class IncorrectNameLengthException extends RuntimeException {
    public IncorrectNameLengthException(String message) {
        super(message);
    }
}
