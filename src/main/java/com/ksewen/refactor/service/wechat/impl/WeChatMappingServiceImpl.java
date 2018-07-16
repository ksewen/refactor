package com.ksewen.refactor.service.wechat.impl;


import com.ksewen.refactor.domain.WeChatAppMappingDomain;
import com.ksewen.refactor.mapper.wechat.WeChatMappingMapper;
import com.ksewen.refactor.service.wechat.WeChatMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: eyee-backend
 * @description:
 * @author: ksewen
 * @create: 2018/7/13 上午10:15
 **/
@Service
public class WeChatMappingServiceImpl implements WeChatMappingService {

    @Autowired
    private WeChatMappingMapper weChatMappingMapper;

    @Override
    public String getSecretByAppId(String appId) {
        WeChatAppMappingDomain appMapping = weChatMappingMapper.selectByAppId(appId);
        if (appMapping == null)
            return null;
        return appMapping.getSecret();
    }
}
