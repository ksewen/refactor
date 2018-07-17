package com.ksewen.refactor.service.key.impl;

import com.ksewen.refactor.service.key.KeyGenerator;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @program: refactor
 * @description:
 * @author: ksewen
 * @create: 2018/7/17 下午2:34
 **/
@Service
public class KeyGeneratorImpl implements KeyGenerator {
    @Override
    public String newId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
