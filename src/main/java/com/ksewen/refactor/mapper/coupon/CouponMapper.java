package com.ksewen.refactor.mapper.coupon;

import com.ksewen.refactor.domain.CouponDomain;
import org.apache.ibatis.annotations.Select;

public interface CouponMapper {

    @Select("SELECT id, name " +
            "FROM coupon " +
            "WHERE id=#{id}")
    CouponDomain selectById(String id);
}
