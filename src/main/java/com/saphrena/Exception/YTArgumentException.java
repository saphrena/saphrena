package com.saphrena.Exception;

/**
 * @author 热河
 * @created 2022/6/16 11:16
 * @project saphrena
 * @Description
 */
public class YTArgumentException extends RuntimeException {

    public YTArgumentException(String message) {
        super(message);
    }

    public YTArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
}
