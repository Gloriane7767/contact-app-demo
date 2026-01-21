package com.gloriane.exception;

public class ExceptionHandler extends RuntimeException{
    public static void handleException(Exception e) {
        System.err.println("An error occurred: " + e.getMessage());
        e.printStackTrace();
    }
}
