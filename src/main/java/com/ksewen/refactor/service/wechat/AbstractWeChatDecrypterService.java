package com.ksewen.refactor.service.wechat;

import com.ksewen.refactor.dto.WeChatAppDecryptDto;
import com.ksewen.refactor.exception.GetWeChatSessionException;
import com.ksewen.refactor.model.GetWeChatSessionModel;
import org.springframework.util.StringUtils;

/**
 * @program: eyee-backend
 * @description:
 * @author: ksewen
 * @create: 2018/7/13 下午3:20
 **/

public abstract class AbstractWeChatDecrypterService implements WeChatDecrypter {
    @Override
    public WeChatAppDecryptDto decrypt(String openId, String encryptedData, String iv) {
        GetWeChatSessionModel wxSessionModel = getWechatSession(openId);
        if (!needDecrypter(wxSessionModel))
            throw new GetWeChatSessionException("invalid user for decry!");
        String unionId = decryptForUnionId(encryptedData, wxSessionModel.getSessionKey(), iv);
        return WeChatAppDecryptDto.newBuilder()
                .unionId(unionId)
                .hasAccount(checkUserExist(unionId))
                .build();
    }

    protected abstract GetWeChatSessionModel getWechatSession(String openId);

    protected abstract String decryptForUnionId(String encryptedData, String sessionKey, String iv);

    protected abstract boolean checkUserExist(String unionId);

    private boolean needDecrypter(GetWeChatSessionModel wxSessionModel) {
        if (wxSessionModel == null)
            return false;
        return !StringUtils.isEmpty(wxSessionModel.getSessionKey())
                && StringUtils.isEmpty(wxSessionModel.getUnionId());
    }
}
