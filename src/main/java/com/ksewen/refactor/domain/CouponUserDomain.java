package com.ksewen.refactor.domain;

/**
 * @program: refactor
 * @description:
 * @author: ksewen
 * @create: 2018/7/17 下午2:31
 **/

public class CouponUserDomain {
    private String id;
    private String couponId;
    private String userId;

    public CouponUserDomain() {
    }

    private CouponUserDomain(Builder builder) {
        setId(builder.id);
        setCouponId(builder.couponId);
        setUserId(builder.userId);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(CouponUserDomain copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.couponId = copy.getCouponId();
        builder.userId = copy.getUserId();
        return builder;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCouponId() {
        return this.couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public static final class Builder {
        private String id;
        private String couponId;
        private String userId;

        private Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder couponId(String val) {
            couponId = val;
            return this;
        }

        public Builder userId(String val) {
            userId = val;
            return this;
        }

        public CouponUserDomain build() {
            return new CouponUserDomain(this);
        }
    }
}
