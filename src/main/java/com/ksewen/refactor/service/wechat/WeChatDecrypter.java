package com.ksewen.refactor.service.wechat;

import com.ksewen.refactor.dto.wechat.WeChatAppDecryptDto;

public interface WeChatDecrypter {
    WeChatAppDecryptDto decrypt(String openId, String encryptedData, String iv);
}
