package com.lezhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients
@EnableAsync  
@ComponentScan(basePackages={"com.lezhi"})
@MapperScan(basePackages = { "com.lezhi.dao"})
public class WebPortalApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(WebPortalApplication.class, args);
    }

//    @Bean
//    public MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        //单个文件最大
//        factory.setMaxFileSize("100MB"); //KB,MB
//        //设置总上传数据总大小
//        factory.setMaxRequestSize("500MB");
//        return factory.createMultipartConfig();
//    }
}
