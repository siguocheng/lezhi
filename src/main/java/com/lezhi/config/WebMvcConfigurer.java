package com.lezhi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/projectPic/**").addResourceLocations("classpath:/projectPic/");
        registry.addResourceHandler("/bigPic/**").addResourceLocations("classpath:/bigPic/");
        registry.addResourceHandler("/clientPic/**").addResourceLocations("classpath:/clientPic/");
        super.addResourceHandlers(registry);
    }
}
