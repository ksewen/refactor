package com.ksewen.refactor.exception;

/**
 * @program: refactor
 * @description:
 * @author: ksewen
 * @create: 2018/7/16 上午11:26
 **/

public class AlreadyReceivedException extends RuntimeException {

    public AlreadyReceivedException() {
        super();
    }

    public AlreadyReceivedException(String message) {
        super(message);
    }
}
