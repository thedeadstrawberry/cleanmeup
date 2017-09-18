package com.thedeadstrawberry.cleanmeup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.thedeadstrawberry.cleanmeup.config", "com.thedeadstrawberry.cleanmeup.controllers"})
public class Application {

	public static void main(String... args) {
		SpringApplication.run(Application.class, args);
	}
}
