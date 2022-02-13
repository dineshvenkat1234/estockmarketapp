package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.controller.ConsumerController;
import com.example.demo.filter.CompanyJWTFilter;

@SpringBootApplication

public class Application {

	@Bean
	public FilterRegistrationBean jwtFilter() {
		FilterRegistrationBean fb = new FilterRegistrationBean();
		fb.setFilter(new CompanyJWTFilter());
		fb.addUrlPatterns("/api/v1.0/*");
		return fb;
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(Application.class, args);
		ConsumerController consumerController=ctx.getBean(ConsumerController.class);
		consumerController.getAuthToken();
	}
	
	@Bean
	public ConsumerController consumerController() {
		return new ConsumerController();
	}

}
