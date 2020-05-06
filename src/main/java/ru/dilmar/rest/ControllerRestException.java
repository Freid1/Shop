package ru.dilmar.rest;

public class ControllerRestException extends RuntimeException {
    public ControllerRestException() {
        super();
    }

    public ControllerRestException(String message) {
        super(message);
    }

    public ControllerRestException(String message, Throwable cause) {
        super(message, cause);
    }

    public ControllerRestException(Throwable cause) {
        super(cause);
    }
}
