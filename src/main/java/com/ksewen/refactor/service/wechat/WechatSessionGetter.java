package com.ksewen.refactor.service.wechat;


import com.ksewen.refactor.dto.WeChatAppSessionDto;

public interface WechatSessionGetter {
    WeChatAppSessionDto getSession(String appId, String code);
}
