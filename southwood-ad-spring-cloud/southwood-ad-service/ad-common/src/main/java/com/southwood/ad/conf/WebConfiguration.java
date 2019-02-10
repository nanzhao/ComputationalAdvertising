package com.southwood.ad.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Created by nanzhao on 2019/2/10 10:43 AM
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>>
                                                   converters) {
        //清空所有的转换器，只留下这一个，以后使用ad-common的包，都会采用这样的配置
        converters.clear();
        converters.add(new MappingJackson2HttpMessageConverter());
    }
}
