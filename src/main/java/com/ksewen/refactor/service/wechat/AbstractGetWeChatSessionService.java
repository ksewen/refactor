package com.ksewen.refactor.service.wechat;


import com.ksewen.refactor.domain.WeChatAppMappingDomain;
import com.ksewen.refactor.dto.WeChatAppSessionDto;
import com.ksewen.refactor.exception.GetWeChatSessionException;
import com.ksewen.refactor.exception.ResourceNotFoundException;
import com.ksewen.refactor.model.GetWeChatSessionModel;
import org.springframework.util.StringUtils;

/**
 * @program: refactor
 * @description:
 * @author: ksewen
 * @create: 2018/7/13 上午10:56
 **/

public abstract class AbstractGetWeChatSessionService implements WechatSessionGetter {

    @Override
    public WeChatAppSessionDto getSession(String appId, String code) {
        String secret = getAppSecret(appId);
        if (StringUtils.isEmpty(secret))
            throw new ResourceNotFoundException("app not exist id: " + appId);

        GetWeChatSessionModel wxSessionModel = getWechatSession(appId, secret, code);
        if (!checkWxSessionModel(wxSessionModel))
            throw new GetWeChatSessionException("get wechat session faild!");

        return WeChatAppSessionDto.newBuilder()
                .openId(wxSessionModel.getOpenId())
                .unionId(wxSessionModel.getUnionId())
                .hasAccount(checkUserExist(wxSessionModel.getUnionId()))
                .build();
    }

    protected abstract String getAppSecret(String appId);

    protected abstract GetWeChatSessionModel getWechatSession(String appId, String secret, String code);

    protected abstract boolean checkUserExist(String unionId);

    private boolean checkMapping(WeChatAppMappingDomain wechatAppMapping) {
        if (wechatAppMapping == null || StringUtils.isEmpty(wechatAppMapping.getSecret()))
            return false;
        return true;
    }

    protected abstract boolean checkWxSessionModel(GetWeChatSessionModel getWxSessionModel);
}
