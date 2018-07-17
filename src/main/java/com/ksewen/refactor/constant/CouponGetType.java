package com.ksewen.refactor.constant;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

public enum CouponGetType {
    GET, ASSIGN, PLATFORM, CDKEY, BESS;

    @JsonCreator
    public static CouponGetType forOrdinal(Integer ordinal) {
        return Arrays.asList(values()).stream()
                .filter(ord -> Integer.valueOf(ordinal).equals(ord.ordinal())).findFirst().orElse(null);
    }
}
