package com.charlee.thread.HandwritingThreadPool;

public class RunnableDenyException extends RuntimeException {
    public RunnableDenyException(String message) {
        super(message);
    }
}
