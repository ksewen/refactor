package com.ksewen.refactor.service.wechat.impl;

import com.ksewen.refactor.exception.WeChatDecrypterException;
import com.ksewen.refactor.model.GetWeChatSessionModel;
import com.ksewen.refactor.model.WeChatOpenDataModel;
import com.ksewen.refactor.service.customer.UserService;
import com.ksewen.refactor.service.encrypt.EncryptService;
import com.ksewen.refactor.service.tools.ObjectMapperService;
import com.ksewen.refactor.service.wechat.AbstractWeChatDecrypterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @program: eyee-backend
 * @description:
 * @author: ksewen
 * @create: 2018/7/13 下午3:38
 **/
@Service
public class WeChatDecrypterServiceImpl extends AbstractWeChatDecrypterService {

    @Autowired
    private UserService userService;

    @Autowired
    private EncryptService encryptService;

    @Autowired
    private ObjectMapperService objectMapperService;

    @Override
    protected GetWeChatSessionModel getWechatSession(String openId) {
        //TODO: get from redis
        return null;
    }

    @Override
    protected String decryptForUnionId(String encryptedData, String sessionKey, String iv) {
        WeChatOpenDataModel data = objectMapperService
                .toModel(encryptService.decrypt(encryptedData, sessionKey, iv), WeChatOpenDataModel.class);
        if (data == null) {
            throw new WeChatDecrypterException("could not decrypt encryptedData");
        }
        return data.getUnionId();
    }

    @Override
    protected boolean checkUserExist(String unionId) {
        if (StringUtils.isEmpty(unionId))
            return false;
        return userService.checkUserExistByWeChat(unionId);
    }
}
