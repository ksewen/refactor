package com.ksewen.refactor.mapper.wechat;

import com.ksewen.refactor.domain.WeChatAppMappingDomain;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface WeChatMappingMapper {

    @Select("SELECT id, appId, appSecret as secret " +
            "from wechat_app_mapping where " +
            "appId=#{appId}")
    WeChatAppMappingDomain selectByAppId(String appId);
}
