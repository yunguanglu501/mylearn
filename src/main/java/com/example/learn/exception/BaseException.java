package com.example.learn.exception;

public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 6214182551800693883L;
    private int status;
    private String message;

    public BaseException(int status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }

    public BaseException(ErrorCode errorCode) {
        this(errorCode.getStatus(), errorCode.getMessage());
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException() {
    }

    public int getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }
}
