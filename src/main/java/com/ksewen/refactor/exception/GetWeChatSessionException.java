package com.ksewen.refactor.exception;

/**
 * @program: refactor
 * @description:
 * @author: ksewen
 * @create: 2018/7/16 上午11:26
 **/

public class GetWeChatSessionException extends RuntimeException {

    public GetWeChatSessionException() {
        super();
    }

    public GetWeChatSessionException(String message) {
        super(message);
    }
}
