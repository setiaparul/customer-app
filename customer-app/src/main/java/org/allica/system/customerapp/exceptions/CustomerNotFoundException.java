package org.allica.system.customerapp.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    private final int statusCode;

    public CustomerNotFoundException(String message) {
        super(message);
        this.statusCode = 404;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
