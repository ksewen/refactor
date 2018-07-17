package com.ksewen.refactor.controller;

import com.ksewen.refactor.dto.ResponseBase;
import com.ksewen.refactor.service.wechat.WeChatDecrypter;
import com.ksewen.refactor.service.wechat.WeChatSessionGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @program: eyee-backend
 * @description:
 * @author: ksewen
 * @create: 2018/7/13 上午9:28
 **/
@RequestMapping("/wechat/open")
@RestController
public class WeChatController {

    @Autowired
    private WeChatSessionGetter weChatSessionGetter;

    @Autowired
    private WeChatDecrypter weChatDecrypter;

    @GetMapping("/appHelp/{appId}")
    public ResponseBase appHelp(@PathVariable("appId") String appId, @RequestParam("code") String code) {
        return ResponseBase.ok(weChatSessionGetter.getSession(appId, code));
    }

    @GetMapping("/appDecrypt")
    public ResponseBase decrypt(@RequestParam("openid") String openId,
                                @RequestParam("encrypteddata") String encryptedData,
                                @RequestParam("iv") String iv) {
        if (StringUtils.isEmpty(openId) || StringUtils.isEmpty(encryptedData) || StringUtils.isEmpty(iv)) {
            return ResponseBase.missingParameter();
        }
        return ResponseBase.ok(weChatDecrypter.decrypt(openId, encryptedData, iv));
    }
}
