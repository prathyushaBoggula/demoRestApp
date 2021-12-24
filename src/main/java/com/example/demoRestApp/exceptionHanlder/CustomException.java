package com.example.demoRestApp.exceptionHanlder;

public class CustomException extends Exception{

    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }
}
