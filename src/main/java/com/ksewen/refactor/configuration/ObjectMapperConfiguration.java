package com.ksewen.refactor.configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * @program: refactor
 * @description:
 * @author: ksewen
 * @create: 2018/7/16 下午2:00
 **/
@Configuration
public class ObjectMapperConfiguration {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Bean(name = "normalObjMapper")
    public ObjectMapper normalObjMapper() {
        return new ObjectMapper();
    }

    @Bean(name = "dtoObjMapper")
    public ObjectMapper dtoObjMapper() {
        return new ObjectMapper()
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .setDateFormat(new SimpleDateFormat(DATE_FORMAT))
                .setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE);
    }
}
