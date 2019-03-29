package com.demo.ssjo;

import com.demo.ssjo.util.ApplicationConfig;
import com.demo.ssjo.util.SessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lec
 * @Title: InterceptorConfig
 * @ProjectName mingbang_v1.0
 * @Description: TODO
 * @date 2019/3/13 10:40
 */
@SpringBootConfiguration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private SessionInterceptor sessionInterceptor;
    @Autowired
    private ApplicationConfig config;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> exclude = new LinkedList<>();
        exclude.add("/index.html");
        exclude.add("/noLogin.html");
        exclude.add("/Content/**");
        exclude.add("/css/**");
        exclude.add("/images/**");
        exclude.add("/js/**");
        exclude.add("/swagger-ui.html");
        exclude.add("/swagger-resources/**");
        exclude.add("/v2/**");
        exclude.add("/check");
        exclude.add("/user/login");
        exclude.add("/user/list");
        registry.addInterceptor(sessionInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(exclude);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:"+config.getUploadPath());
    }
}
