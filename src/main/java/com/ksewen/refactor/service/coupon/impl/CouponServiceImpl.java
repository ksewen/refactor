package com.ksewen.refactor.service.coupon.impl;

import com.ksewen.refactor.constant.CouponGetType;
import com.ksewen.refactor.domain.CouponDomain;
import com.ksewen.refactor.domain.CouponUserDomain;
import com.ksewen.refactor.exception.AlreadyReceivedException;
import com.ksewen.refactor.exception.OutOfTimeRangeException;
import com.ksewen.refactor.exception.OverCountException;
import com.ksewen.refactor.exception.ResourceNotFoundException;
import com.ksewen.refactor.mapper.coupon.CouponMapper;
import com.ksewen.refactor.mapper.coupon.CouponUserMapper;
import com.ksewen.refactor.service.coupon.CouponService;
import com.ksewen.refactor.service.key.KeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @program: refactor
 * @description:
 * @author: ksewen
 * @create: 2018/7/17 下午1:54
 **/
@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponMapper couponMapper;

    @Autowired
    private CouponUserMapper couponUserMapper;

    @Autowired
    private KeyGenerator keyGenerator;

    @Override
    public boolean getCoupon(String couponId, String userId) {
        CouponDomain coupon = couponMapper.selectById(couponId);

        if (coupon == null || !CouponGetType.GET.equals(coupon.getSendType()))
            throw new ResourceNotFoundException("coupon does not exist! id: " + couponId);

        Date now = new Date();
        if (coupon.getGetBeginTime() != null && coupon.getGetEndTime() != null
                && (coupon.getGetBeginTime().after(now)) || coupon.getGetEndTime().before(now))
            throw new OutOfTimeRangeException("incorrect time to get this coupon! id: " + couponId);

//        if (coupon.isOverCount())
//            throw new OverCountException("is over count! id: " + couponId);
//
//        if (coupon.isGeted() && (coupon.getLimitCount() > 0 && coupon.getGotCount() >= coupon.getLimitCount()))
//            throw new AlreadyReceivedException("already received! coupon: " + couponId + ", user: " + userId);

        return couponUserMapper.insertCouponUser(CouponUserDomain.newBuilder()
                .id(keyGenerator.newId())
                .couponId(couponId)
                .userId(userId)
                .build()) > 0;
    }
}
