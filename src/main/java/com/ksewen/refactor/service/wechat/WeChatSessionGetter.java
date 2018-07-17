package com.ksewen.refactor.service.wechat;


import com.ksewen.refactor.dto.wechat.WeChatAppSessionDto;

public interface WeChatSessionGetter {
    WeChatAppSessionDto getSession(String appId, String code);
}
