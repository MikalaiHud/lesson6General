package com.epam.hud.exception;

public class GeneralException extends Exception {
    private String message;

    public GeneralException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
