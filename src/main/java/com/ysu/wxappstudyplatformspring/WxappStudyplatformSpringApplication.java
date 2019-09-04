package com.ysu.wxappstudyplatformspring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(value = "com.ysu.wxappstudyplatformspring.Dao")
public class WxappStudyplatformSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(WxappStudyplatformSpringApplication.class, args);
		System.out.println("程序正在运行！！！");
	}

}
