package com.xbird.exception;


public class UserNotExistException extends RuntimeException {

    private String id;

    public UserNotExistException(String id) {
        super("user is not exception.");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
