package com.ksewen.refactor.dto;

import com.ksewen.refactor.constant.ResultCode;

import java.util.Date;

/**
 * @program: refactor
 * @description:
 * @author: ksewen
 * @create: 2018/7/17 上午9:59
 **/

public class ResponseBase<T> {
    private ResultCode code;
    private String msg;
    private Date serverTime = new Date();
    private T data;

    public ResponseBase() {
    }

    public ResponseBase(ResultCode code) {
        this.code = code;
        this.msg = code.getDescription();
    }

    public ResponseBase(ResultCode code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseBase(ResultCode code, T data) {
        this.code = code;
        this.msg = code.getDescription();
        this.data = data;
    }

    public ResponseBase(ResultCode code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultCode getCode() {
        return this.code;
    }

    public void setCode(ResultCode code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getServerTime() {
        return this.serverTime;
    }

    public void setServerTime(Date serverTime) {
        this.serverTime = serverTime;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    //========================OK ============================
    public static <T> ResponseBase<T> ok(T data, String msg) {
        return new ResponseBase(ResultCode.SUCCESS, msg, data);
    }

    public static <T> ResponseBase<T> ok() {
        return ok(null, null);
    }

    public static <T> ResponseBase<T> ok(String msg) {
        return ok(null, msg);
    }

    public static <T> ResponseBase<T> ok(T data) {
        return ok(data, null);
    }

    //========================ServerError ============================
    public static <T> ResponseBase<T> serverError(T data, String msg) {
        return new ResponseBase(ResultCode.SERVER_ERROR, msg, data);
    }

    public static <T> ResponseBase<T> serverError() {
        return serverError(null, null);
    }

    public static <T> ResponseBase<T> serverError(String msg) {
        return serverError(null, msg);
    }

    public static <T> ResponseBase<T> serverError(T data) {
        return serverError(data, null);
    }

    //========================MissingParameter ============================
    public static <T> ResponseBase<T> missingParameter(T data, String msg) {
        return new ResponseBase(ResultCode.MISSING_PARAMETER, msg, data);
    }

    public static <T> ResponseBase<T> missingParameter() {
        return missingParameter(null, null);
    }

    public static <T> ResponseBase<T> missingParameter(String msg) {
        return missingParameter(null, msg);
    }

    public static <T> ResponseBase<T> missingParameter(T data) {
        return missingParameter(data, null);
    }

    //========================InvalidParameter ============================
    public static <T> ResponseBase<T> invalidParameter(T data, String msg) {
        return new ResponseBase(ResultCode.INVALID_PARAMETER, msg, data);
    }

    public static <T> ResponseBase<T> invalidParameter() {
        return invalidParameter(null, null);
    }

    public static <T> ResponseBase<T> invalidParameter(String msg) {
        return invalidParameter(null, msg);
    }

    public static <T> ResponseBase<T> invalidParameter(T data) {
        return invalidParameter(data, null);
    }

    //========================OperationFailure ============================
    public static <T> ResponseBase<T> operationFailure(T data, String msg) {
        return new ResponseBase(ResultCode.OPERATION_FAILURE, msg, data);
    }

    public static <T> ResponseBase<T> operationFailure() {
        return operationFailure(null, null);
    }

    public static <T> ResponseBase<T> operationFailure(String msg) {
        return operationFailure(null, msg);
    }

    public static <T> ResponseBase<T> operationFailure(T data) {
        return operationFailure(data, null);
    }


}
