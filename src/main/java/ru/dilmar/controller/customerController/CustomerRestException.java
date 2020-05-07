package ru.dilmar.controller.customerController;

public class CustomerRestException extends RuntimeException {
    public CustomerRestException() {
        super();
    }

    public CustomerRestException(String message) {
        super(message);
    }

    public CustomerRestException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerRestException(Throwable cause) {
        super(cause);
    }
}
