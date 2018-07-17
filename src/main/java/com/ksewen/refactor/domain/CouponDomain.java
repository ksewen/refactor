package com.ksewen.refactor.domain;

import com.ksewen.refactor.constant.CouponGetType;

import java.util.Date;

/**
 * @program: refactor
 * @description:
 * @author: ksewen
 * @create: 2018/7/17 下午1:55
 **/

public class CouponDomain {
    private String id;
    private String name;
    private CouponGetType sendType;
    private Date getBeginTime;
    private Date getEndTime;
    private Integer getLimit;

    public CouponDomain() {
    }

    private CouponDomain(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setSendType(builder.sendType);
        setGetBeginTime(builder.getBeginTime);
        setGetEndTime(builder.getEndTime);
        setGetLimit(builder.getLimit);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(CouponDomain copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.name = copy.getName();
        builder.sendType = copy.getSendType();
        builder.getBeginTime = copy.getGetBeginTime();
        builder.getEndTime = copy.getGetEndTime();
        builder.getLimit = copy.getGetLimit();
        return builder;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CouponGetType getSendType() {
        return this.sendType;
    }

    public void setSendType(CouponGetType sendType) {
        this.sendType = sendType;
    }

    public Date getGetBeginTime() {
        return this.getBeginTime;
    }

    public void setGetBeginTime(Date getBeginTime) {
        this.getBeginTime = getBeginTime;
    }

    public Date getGetEndTime() {
        return this.getEndTime;
    }

    public void setGetEndTime(Date getEndTime) {
        this.getEndTime = getEndTime;
    }

    public Integer getGetLimit() {
        return this.getLimit;
    }

    public void setGetLimit(Integer getLimit) {
        this.getLimit = getLimit;
    }


    public static final class Builder {
        private String id;
        private String name;
        private CouponGetType sendType;
        private Date getBeginTime;
        private Date getEndTime;
        private Integer getLimit;

        private Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder sendType(CouponGetType val) {
            sendType = val;
            return this;
        }

        public Builder getBeginTime(Date val) {
            getBeginTime = val;
            return this;
        }

        public Builder getEndTime(Date val) {
            getEndTime = val;
            return this;
        }

        public Builder getLimit(Integer val) {
            getLimit = val;
            return this;
        }

        public CouponDomain build() {
            return new CouponDomain(this);
        }
    }
}
