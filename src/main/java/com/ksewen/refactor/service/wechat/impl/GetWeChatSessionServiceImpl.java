package com.ksewen.refactor.service.wechat.impl;

import com.ksewen.refactor.domain.WeChatAppMappingDomain;
import com.ksewen.refactor.mapper.wechat.WeChatMappingMapper;
import com.ksewen.refactor.model.GetWeChatSessionModel;
import com.ksewen.refactor.service.customer.UserService;
import com.ksewen.refactor.service.wechat.AbstractGetWeChatSessionService;
import com.ksewen.refactor.service.wechat.WeChatAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @program: eyee-backend
 * @description:
 * @author: ksewen
 * @create: 2018/7/13 上午11:47
 **/
@Service
public class GetWeChatSessionServiceImpl extends AbstractGetWeChatSessionService {

    @Autowired
    private WeChatMappingMapper weChatMappingMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private WeChatAuthService weChatAuthService;

    private static final Logger logger = LoggerFactory.getLogger(GetWeChatSessionServiceImpl.class);

    @Override
    protected WeChatAppMappingDomain getWechatMapping(String appId) {
        WeChatAppMappingDomain appMapping = weChatMappingMapper.selectByAppId(appId);
        if (appMapping == null)
            return null;
        return appMapping;
    }

    @Override
    protected GetWeChatSessionModel getWechatSession(String appId, String secret, String code) {
        return weChatAuthService.getWechatSession(appId, secret, code);
    }

    @Override
    protected boolean checkUserExist(String unionId) {
        if (StringUtils.isEmpty(unionId))
            return false;
        return userService.checkUserExistByWeChat(unionId);
    }

    @Override
    protected boolean checkWxSessionModel(GetWeChatSessionModel getWxSessionModel) {
        if (getWxSessionModel == null) {
            logger.error("can not get wechat session!");
            return false;
        }
        if (getWxSessionModel.getErrCode() != null) {
            logger.error("error when get wechat session, code:" + getWxSessionModel.getErrCode() + "，message:" + getWxSessionModel.getErrMsg());
            return false;
        }
        if (StringUtils.isEmpty(getWxSessionModel.getOpenId())) {
            logger.error("can not get wechat session!");
            return false;
        }
        return true;
    }
}
