package org.allica.system.customerapp.exceptions;

public class CustomerCreationFailureException extends  Exception{
    private int statusCode;
    private static int defaultStatusCode = 500;
    public CustomerCreationFailureException(String message) {
        super(message);
        this.statusCode = defaultStatusCode;
    }
    public CustomerCreationFailureException(String message, int code) {
        super(message);
        this.statusCode = code;
    }
}
