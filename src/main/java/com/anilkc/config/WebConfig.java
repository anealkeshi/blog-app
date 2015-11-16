package com.anilkc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.anilkc.blog.config.SecurityConfig;

@Configuration
@Import(SecurityConfig.class)
public class WebConfig {

}
