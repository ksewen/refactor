package com.ksewen.refactor.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @program: refactor
 * @description:
 * @author: ksewen
 * @create: 2018/7/13 下午3:32
 **/

public class WeChatOpenDataModel {

    @JsonProperty("openid")
    private String openId;

    @JsonProperty("unionid")
    private String unionId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }
}
