/*
 * Copyright (c) 2019, ARNAB BANERJEE. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted only for academic purposes.
 * 
 * For further queries / info: arnab.ban09@gmail.com
 */

package com.arnab.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * This is the main application where the ball starts rolling.
 * 1. It is annotated with @EnableEurekaClient to notify that this application will behave as a Eureka Client application and will register
 * with a Eureka server running on port 8761 and also calls the Eureka Server for dynamic resolution of applications' URL.
 * 2. It is also annotated with @EnableCircuitBreaker to notify that the Hystrix Circuit Breaker will be active on this application. So that
 * the circuit breaker can be used further in the application.
 * 3. It is also annotated with @EnableHystrixDashboard to notify that the Hystrix Dashboard will be active on this application and will 
 * monitor this application. The streaming url is configured in the application.properties file. When the application starts, hit the browser,
 * and type http://localhost:8080/hystrix and hit. You can see the Hystrix Dashboard.
 * @author Arnab
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
public class MovieServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceClientApplication.class, args);
	}

}
