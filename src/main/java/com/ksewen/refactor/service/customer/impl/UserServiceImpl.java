package com.ksewen.refactor.service.customer.impl;

import com.ksewen.refactor.service.customer.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @program: refactor
 * @description:
 * @author: ksewen
 * @create: 2018/7/15 下午10:40
 **/
@Service
public class UserServiceImpl implements UserService {

    @Override
    public boolean checkUserExistById(String id) {
        return false;
    }

    @Override
    public boolean checkUserExistByWeChat(String unionId) {
        if (StringUtils.isEmpty(unionId))
            return false;
        return true;
    }
}
