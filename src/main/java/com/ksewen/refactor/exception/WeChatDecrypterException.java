package com.ksewen.refactor.exception;

/**
 * @program: refactor
 * @description:
 * @author: ksewen
 * @create: 2018/7/16 上午11:26
 **/

public class WeChatDecrypterException extends RuntimeException {

    public WeChatDecrypterException() {
        super();
    }

    public WeChatDecrypterException(String message) {
        super(message);
    }
}
