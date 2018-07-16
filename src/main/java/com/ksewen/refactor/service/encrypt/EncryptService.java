package com.ksewen.refactor.service.encrypt;

public interface EncryptService {
    String decrypt(String encryptedData, String sessionKey, String iv);
}
