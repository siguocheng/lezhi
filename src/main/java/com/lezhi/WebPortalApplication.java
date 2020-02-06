package com.lezhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages={"com.lezhi"})
@MapperScan(basePackages = { "com.lezhi.dao"})
public class WebPortalApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(WebPortalApplication.class, args);
    }
}
