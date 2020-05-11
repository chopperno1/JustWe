package com.JustWe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// mybatis批量扫描
@MapperScan(value = "com.JustWe.mapper")
@SpringBootApplication
public class JustWeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustWeApplication.class, args);
	}

}
