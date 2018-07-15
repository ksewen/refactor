package com.ksewen.refactor.service.encrypt;

public interface WeChatCryptService {
    String decrypt(String encryptedData, String sessionKey, String iv);
}
