package com.ksewen.refactor.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @program: eyee-backend
 * @description:
 * @author: ksewen
 * @create: 2018/7/13 上午10:43
 **/

public class GetWeChatSessionModel {

    @JsonProperty("openid")
    private String openId;

    @JsonProperty("unionid")
    private String unionId;

    @JsonProperty("errcode")
    private Integer errCode;

    @JsonProperty("errmsg")
    private String errMsg;

    @JsonProperty("session_key")
    private String sessionKey;

    @JsonProperty("expires_in")
    private String expiresIn;

    public String getOpenId() {
        return this.openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return this.unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Integer getErrCode() {
        return this.errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getSessionKey() {
        return this.sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getExpiresIn() {
        return this.expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }
}
