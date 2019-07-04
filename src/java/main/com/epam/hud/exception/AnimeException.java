package com.epam.hud.exception;

public class AnimeException extends Exception {
    private String message;

    public AnimeException(String message) {
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
