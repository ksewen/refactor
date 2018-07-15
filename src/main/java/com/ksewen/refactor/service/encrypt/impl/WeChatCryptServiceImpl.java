package com.ksewen.refactor.service.encrypt.impl;

import com.ksewen.refactor.service.encrypt.WeChatCryptService;
import com.ksewen.refactor.utils.WeChatPKCS7Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @program: refactor
 * @description:
 * @author: ksewen
 * @create: 2018/7/15 下午10:21
 **/
@Service
public class WeChatCryptServiceImpl implements WeChatCryptService {

    private static final String ALGORITHM = "AES/CBC/NoPadding";
    private static final String ALGORITHM_TYPE = "AES";
    private static final String CHARSET = "UTF-8";

    private static final Logger logger = LoggerFactory.getLogger(WeChatCryptServiceImpl.class);

    @Override
    public String decrypt(String encryptedData, String sessionKey, String iv) {
        try {
            checkNotNull(encryptedData);
            checkNotNull(sessionKey);
            checkNotNull(iv);
            Cipher cipher = Cipher.getInstance(ALGORITHM);

            byte[] _encryptedData = Base64.getDecoder().decode(encryptedData);
            byte[] _sessionKey = Base64.getDecoder().decode(sessionKey);
            byte[] _iv = Base64.getDecoder().decode(iv);

            SecretKeySpec secretKeySpec = new SecretKeySpec(_sessionKey, ALGORITHM_TYPE);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(_iv);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

            byte[] original = cipher.doFinal(_encryptedData);
            byte[] bytes = WeChatPKCS7Encoder.decode(original);
            return new String(bytes, CHARSET);
        } catch (NullPointerException npe) {
            logger.error("illegal null param, data: {}, key:{}, iv={}", encryptedData, sessionKey, iv, npe);
        } catch (Exception ex) {
            logger.error("decrypt faild! data: {}, key:{}, iv={}", encryptedData, sessionKey, iv, ex);
        }
        return null;
    }
}
