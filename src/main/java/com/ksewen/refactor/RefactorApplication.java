package com.ksewen.refactor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ksewen.refactor.mapper")
public class RefactorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RefactorApplication.class, args);
	}
}
