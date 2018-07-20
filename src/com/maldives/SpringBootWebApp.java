package com.maldives;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages="com.maldives")
public class SpringBootWebApp extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootWebApp.class);
	}

	public static void main(String[] args) throws Exception {
		System.out.println("main....");
		SpringApplication.run(SpringBootWebApp.class, args);
	}
	
	/*public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringBootWebApp.class, args);
		for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}*/
}