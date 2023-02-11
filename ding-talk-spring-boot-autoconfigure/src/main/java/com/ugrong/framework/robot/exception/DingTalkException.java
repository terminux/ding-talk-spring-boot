package com.ugrong.framework.robot.exception;

import com.ugrong.framework.robot.model.DingTalkResponse;

/**
 * The type Ding talk exception.
 */
public class DingTalkException extends RuntimeException {

    private DingTalkResponse errorInfo;

    /**
     * Gets error info.
     *
     * @return the error info
     */
    public DingTalkResponse getErrorInfo() {
        return errorInfo;
    }

    /**
     * Instantiates a new Ding talk exception.
     *
     * @param cause the cause
     */
    public DingTalkException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Ding talk exception.
     *
     * @param message the message
     */
    public DingTalkException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Ding talk exception.
     *
     * @param message   the message
     * @param errorInfo the error info
     */
    public DingTalkException(String message, DingTalkResponse errorInfo) {
        super(message);
    }

}
