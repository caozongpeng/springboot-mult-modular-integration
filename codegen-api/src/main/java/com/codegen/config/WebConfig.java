package com.codegen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 配置web访问
 *
 * @author KyrieCao
 * @date 2020/3/25 22:38
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/");
    }
    /**
     * 多模块的jsp访问，默认是src/main/webapp，但是多模块的目录只设置yml文件不行
     *
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
        // jsp目录
        resolver.setPrefix("/WEB-INF/jsp/");
        // 后缀
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
