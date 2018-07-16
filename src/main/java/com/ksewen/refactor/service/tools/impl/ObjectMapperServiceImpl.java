package com.ksewen.refactor.service.tools.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ksewen.refactor.service.tools.ObjectMapperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @program: refactor
 * @description:
 * @author: ksewen
 * @create: 2018/7/16 下午1:56
 **/
@Service
public class ObjectMapperServiceImpl implements ObjectMapperService {

    private static final Logger logger = LoggerFactory.getLogger(ObjectMapperServiceImpl.class);

    @Resource(name = "dtoObjMapper")
    private ObjectMapper objectMapper;

    @Override
    public <T> T toModel(String jsonString, Class<T> clazz) {
        try {
            if(!StringUtils.isEmpty(jsonString)) {
                return objectMapper
                        .readerFor(clazz)
                        .readValue(jsonString);
            }
            return null;
        } catch (Exception e) {
            logger.error("serialize java object error, json: {}", jsonString, e);
            return null;
        }
    }

    @Override
    public <T> String toJson(T object, Class<T> clazz) {
        try {
            return objectMapper
                    .writerFor(clazz)
                    .writeValueAsString(object);
        } catch (Exception e) {
            logger.debug("deserialize java object {} error", object.toString(), e);
        }
        return null;
    }
}
