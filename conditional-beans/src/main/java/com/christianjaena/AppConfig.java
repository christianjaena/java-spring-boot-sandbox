package com.christianjaena;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MyService myService() {
        return new MyService();
    }

    @Bean
    @ConditionalOnProperty(prefix="feature.facial-login", name = "enabled", havingValue = "true")
    public FacialLogin facialLogin() {
        return new FacialLogin();
    }

    @Bean
    @ConditionalOnBean(FacialLogin.class)
    public Login login() {
        return new Login();
    }

}
