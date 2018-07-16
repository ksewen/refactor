package com.ksewen.refactor.domain;


/**
 * @program: refactor
 * @description:
 * @author: ksewen
 * @create: 2018/7/13 上午9:36
 **/

public class WeChatAppMappingDomain {

    private String id;

    private String appId;

    private String secret;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return this.secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
