package com.ksewen.refactor.exception;

/**
 * @program: refactor
 * @description:
 * @author: ksewen
 * @create: 2018/7/16 上午11:26
 **/

public class OutOfTimeRangeException extends RuntimeException {

    public OutOfTimeRangeException() {
        super();
    }

    public OutOfTimeRangeException(String message) {
        super(message);
    }
}
