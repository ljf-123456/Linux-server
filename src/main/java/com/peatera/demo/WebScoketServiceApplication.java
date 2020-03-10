package com.peatera.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan("com.peatera.*")
public class WebScoketServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebScoketServiceApplication.class, args);
	}

}
