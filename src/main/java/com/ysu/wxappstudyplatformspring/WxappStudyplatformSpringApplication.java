package com.ysu.wxappstudyplatformspring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
@MapperScan(value = "com.ysu.wxappstudyplatformspring.Dao")
public class WxappStudyplatformSpringApplication {

	public static void main(String[] args) {


		SpringApplication.run(WxappStudyplatformSpringApplication.class, args);
		System.out.println("程序正在运行！！！");
	}

	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};

	}


}
