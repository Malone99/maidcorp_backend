package com.fmc.maidcorp.corsconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class CorsConfig {


    public WebMvcConfigurer getCorsConfigaration(){
        return  new WebMvcConfigurer() {

            @Value("${allowed.origin}")
            private String allowedOrigin;
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
//                        .allowedOrigins("http://localhost:3000/") replaced by allowedOrigin
                        .allowedOrigins(allowedOrigin)
                        .allowedMethods("GET","POST","PUT","DELETE")
                        .allowedHeaders("*");
            }
        };
    }
}
