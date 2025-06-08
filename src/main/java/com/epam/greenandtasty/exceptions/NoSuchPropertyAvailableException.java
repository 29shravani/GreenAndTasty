package com.epam.greenandtasty.exceptions;

public class NoSuchPropertyAvailableException extends RuntimeException {
    public NoSuchPropertyAvailableException() {
        super("No such Property is set in the config.properties");
    }

    public NoSuchPropertyAvailableException(String message) {
        super("No such Property is set in the config.properties " + message);
    }
}
