package com.ksewen.refactor.controller;

import com.ksewen.refactor.dto.ResponseBase;
import com.ksewen.refactor.exception.ResourceNotFoundException;
import com.ksewen.refactor.exception.UserNotFoundException;
import com.ksewen.refactor.service.coupon.CouponService;
import com.ksewen.refactor.service.customer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @program: refactor
 * @description:
 * @author: ksewen
 * @create: 2018/7/17 下午2:00
 **/
@RequestMapping("/coupon")
@RestController
public class CouponController {

    @Autowired
    private UserService userService;

    @Autowired
    private CouponService couponService;

    @GetMapping("/getCoupon/{couponId}")
    public ResponseBase appHelp(@PathVariable("couponId") String couponId, @RequestParam("userid") String userId) {
        if (StringUtils.isEmpty(userId))
            return ResponseBase.missingParameter();

        Optional.ofNullable(userService.checkUserExistById(userId))
                .orElseThrow(() -> new UserNotFoundException());

        if (!couponService.getCoupon(couponId, userId))
            return ResponseBase.operationFailure();
        return ResponseBase.ok();
    }
}
