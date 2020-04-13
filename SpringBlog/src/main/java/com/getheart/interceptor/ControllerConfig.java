package com.getheart.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Json
 * @date 2020-31-18:14
 */
@Configuration
public class ControllerConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LonginInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin")
                .excludePathPatterns("/admin/login");

    }
}
