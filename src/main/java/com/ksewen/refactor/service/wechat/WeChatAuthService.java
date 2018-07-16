package com.ksewen.refactor.service.wechat;


import com.ksewen.refactor.model.GetWeChatSessionModel;

public interface WeChatAuthService {
    GetWeChatSessionModel getWechatSession(String appId, String secret, String code);
}
