package com.ksewen.refactor.service.customer;

/**
 * @program: refactor
 * @description:
 * @author: ksewen
 * @create: 2018/7/15 下午10:39
 **/

public interface UserService {
    boolean checkUserExistById(String id);
    boolean checkUserExistByWeChat(String unionId);
}
