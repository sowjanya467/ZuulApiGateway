package com.todo.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.todo.zuul.filters.PreFilter;
/*************************************************************************************************************
*
* purpose:zuul gateway to provide common gateway for multiple microservice applications
* 
* @author sowjanya467
* @version 1.0
* @since 31-07-18
*
**************************************************************************************************/

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayApplication.class, args);
	}
	@Bean
	public PreFilter filter()
	{
		return new PreFilter();
	}
}
