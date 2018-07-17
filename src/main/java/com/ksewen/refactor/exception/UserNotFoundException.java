package com.ksewen.refactor.exception;

/**
 * @program: refactor
 * @description:
 * @author: ksewen
 * @create: 2018/7/16 上午11:26
 **/

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
