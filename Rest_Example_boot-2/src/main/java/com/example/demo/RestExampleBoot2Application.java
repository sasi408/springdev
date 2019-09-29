package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class RestExampleBoot2Application {

	public static void main(String[] args) {
		SpringApplication.run(RestExampleBoot2Application.class, args);
	}

}
