package com.wdq.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by wdq on 2018/3/26.
 */
@Configuration
@ComponentScan(basePackages = "com.wdq")
@EnableTransactionManagement
@Import(AppDataConfig.class)
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placehodlerConfigurer() {

        return new PropertySourcesPlaceholderConfigurer();
    }


}
