package com.lezhi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploadBigProject/**").addResourceLocations("classpath:/uploadBigProject/");
        registry.addResourceHandler("/uploadProject/**").addResourceLocations("classpath:/uploadProject/");
        registry.addResourceHandler("/uploadVideoProject/**").addResourceLocations("classpath:/uploadVideoProject/");
        registry.addResourceHandler("/DTUFirmware/**").addResourceLocations("classpath:/DTUFirmware/");
        registry.addResourceHandler("/projectPic/**").addResourceLocations("classpath:/projectPic/");
        registry.addResourceHandler("/uploadScreenProjectPicture/**").addResourceLocations("classpath:/uploadScreenProjectPicture/");
        registry.addResourceHandler("/uploadEquipmenTypePicture/**").addResourceLocations("classpath:/uploadEquipmenTypePicture/");
        registry.addResourceHandler("/uploadTradePicture/**").addResourceLocations("classpath:/uploadTradePicture/");
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
