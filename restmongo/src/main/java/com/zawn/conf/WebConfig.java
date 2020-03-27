package com.zawn.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zawn.conversion.UploadFileBoxEnumConverter;

//@Configuration
public class WebConfig implements WebMvcConfigurer {
 
    @Override
    public void addFormatters(FormatterRegistry registry) {
        //registry.addConverter(new UploadFileBoxEnumConverter());
    }
}