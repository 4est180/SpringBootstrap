package ru.kata.Task_3_1_3.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin").setViewName("role_admin");
        registry.addViewController("/user").setViewName("role_user");
        registry.addRedirectViewController("/", "/login");
    }
}
