package com.ksewen.refactor.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * @program: refactor
 * @description:
 * @author: ksewen
 * @create: 2018/7/17 上午10:01
 **/

public enum  ResultCode {
    SUCCESS(07200, "SUCCESS"),
    SERVER_ERROR(07500, "SERVER_ERROR"),
    MISSING_PARAMETER(07502, "MISSING_PARAMETER"),
    INVALID_PARAMETER(07503, "INVALID_PARAMETER"),
    OPERATION_FAILURE(07600, "OPERATION_FAILURE");


    private Integer code;
    private String description;

    ResultCode(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonCreator
    public static ResultCode forCode(Integer code) {
        return Arrays.asList(values()).stream()
                .filter(resultCode -> resultCode.getCode() == code).findFirst().orElse(SERVER_ERROR);
    }
}
