package com.ksewen.refactor.dto.wechat;

/**
 * @program: refactor
 * @description:
 * @author: ksewen
 * @create: 2018/7/13 上午11:09
 **/

public class WeChatAppSessionDto {

    private String openId;
    private String unionId;
    private Boolean hasAccount;

    private WeChatAppSessionDto(Builder builder) {
        setOpenId(builder.openId);
        setUnionId(builder.unionId);
        setHasAccount(builder.hasAccount);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(WeChatAppSessionDto copy) {
        Builder builder = new Builder();
        builder.openId = copy.getOpenId();
        builder.unionId = copy.getUnionId();
        builder.hasAccount = copy.getHasAccount();
        return builder;
    }

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

    public Boolean getHasAccount() {
        return this.hasAccount;
    }

    public void setHasAccount(Boolean hasAccount) {
        this.hasAccount = hasAccount;
    }

    public WeChatAppSessionDto() {
    }


    public static final class Builder {
        private String openId;
        private String unionId;
        private Boolean hasAccount;

        private Builder() {
        }

        public Builder openId(String val) {
            openId = val;
            return this;
        }

        public Builder unionId(String val) {
            unionId = val;
            return this;
        }

        public Builder hasAccount(Boolean val) {
            hasAccount = val;
            return this;
        }

        public WeChatAppSessionDto build() {
            return new WeChatAppSessionDto(this);
        }
    }
}
