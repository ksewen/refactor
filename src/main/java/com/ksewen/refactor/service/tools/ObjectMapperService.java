package com.ksewen.refactor.service.tools;

/**
 * @program: refactor
 * @description:
 * @author: ksewen
 * @create: 2018/7/16 下午1:55
 **/

public interface ObjectMapperService {
    <T> T toModel(String jsonString, Class<T> clazz);
    <T> String toJson(T object, Class<T> clazz);
}
