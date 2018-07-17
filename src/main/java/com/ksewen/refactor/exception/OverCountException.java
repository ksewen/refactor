package com.ksewen.refactor.exception;

/**
 * @program: refactor
 * @description:
 * @author: ksewen
 * @create: 2018/7/16 上午11:26
 **/

public class OverCountException extends RuntimeException {

    public OverCountException() {
        super();
    }

    public OverCountException(String message) {
        super(message);
    }
}
