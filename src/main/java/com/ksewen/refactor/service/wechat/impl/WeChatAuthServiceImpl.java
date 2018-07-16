package com.ksewen.refactor.service.wechat.impl;


import com.ksewen.refactor.model.GetWeChatSessionModel;
import com.ksewen.refactor.service.wechat.WeChatAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * @program: eyee-backend
 * @description:
 * @author: ksewen
 * @create: 2018/7/13 下午2:22
 **/
@Service
public class WeChatAuthServiceImpl implements WeChatAuthService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String WX_OPEN_URL = "https://api.weixin.qq.com/sns/jscode2session";

    @Override
    public GetWeChatSessionModel getWechatSession(String appId, String secret, String code) {
        URI uri = UriComponentsBuilder.fromUriString(WX_OPEN_URL)
                .queryParam("appid", appId)
                .queryParam("secret", secret)
                .queryParam("js_code", code)
                .queryParam("grant_type", "authorization_code")
                .build().toUri();

        return restTemplate.getForObject(uri, GetWeChatSessionModel.class);
    }
}
