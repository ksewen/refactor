package com.ksewen.refactor.dto;

/**
 * @program: eyee-backend
 * @description:
 * @author: ksewen
 * @create: 2018/7/13 下午2:29
 **/

public class WeChatAppDecryptDto {
    private String unionId;
    private Boolean hasAccount;

    public WeChatAppDecryptDto() {
    }

    private WeChatAppDecryptDto(Builder builder) {
        setUnionId(builder.unionId);
        setHasAccount(builder.hasAccount);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(WeChatAppDecryptDto copy) {
        Builder builder = new Builder();
        builder.unionId = copy.getUnionId();
        builder.hasAccount = copy.getHasAccount();
        return builder;
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


    public static final class Builder {
        private String unionId;
        private Boolean hasAccount;

        private Builder() {
        }

        public Builder unionId(String val) {
            unionId = val;
            return this;
        }

        public Builder hasAccount(Boolean val) {
            hasAccount = val;
            return this;
        }

        public WeChatAppDecryptDto build() {
            return new WeChatAppDecryptDto(this);
        }
    }
}
