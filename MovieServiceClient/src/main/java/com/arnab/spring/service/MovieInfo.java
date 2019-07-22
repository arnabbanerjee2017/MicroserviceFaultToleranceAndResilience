/*
 * Copyright (c) 2019, ARNAB BANERJEE. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted only for academic purposes.
 * 
 * For further queries / info: arnab.ban09@gmail.com
 */

package com.arnab.spring.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**
 * This class methods can be written inside the main Service class - MovieService.java. But if it was written there, the application would
 * fail. Because of working of Hystrix. Hystrix creates a proxy class of the class holding @HystrixCommand methods. So if the @HystrixCoammand
 * methods were written inside the main Service class, Hystrix would not be able to create the proxy class as the class is already created and 
 * managed by the Spring container. So the application would fail. 
 * This is why this class is created separately and it is marked with @Service too to identify it as a Service class and to become 
 * identifiable while component scanning. So when the request comes at the main Service class, the main Service class will call this class'
 * methods. And Hystrix will create a proxy class of this class. So the request will be handled by the Hystrix proxy class instead of the
 * actual Service class. This way Hystrix works.
 * @author Arnab
 *
 */
@Service
public class MovieInfo {
	
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * The property of the @HystrixCommand is as follows -
	 * 1. fallbackMethod - This is the method to call at the time of fallback. Fallback happens when there is some error 
	 * in the response it receives from the called API. 
	 * 2. commandProperties - It takes an array of @HystrixProperty . So here the properties are included - 
	 * 			a) execution.isolation.thread.timeoutInMilliseconds - This property tells when to timeout when a request is pending.
	 * 				Currently it is set 1 to forcefully fallback the service. If it is set to 1000, then it is to test the Hystrix
	 * 				Dashboard service. If you want you can set anything and test. If it is set to 1000, then it means it will get the
	 * 				response from the called API and this means the circuit is a closed circuit.
	 * 			b) circuitBreaker.requestVolumeThreshold - This property considers the last n requests, here it is 5 requests. 
	 * 			c) circuitBreaker.errorThresholdPercentage - This is the percentage of the above property, like if the 
	 * 				requestVolumeThreshold is 6, then 50% of 6 is 3. So in that case, it will count for 3 errors in the last 6 requests. 
	 * 				If 3 errors are found in the last 6 requests, then the circuit breaker will break/fail.
	 * 			d) circuitBreaker.sleepWindowInMilliseconds - Now as just above this statement, stated that if 50% of n last requests failed,
	 * 				the circuit breaker will break/fail. In that case this property tells that how much time the circuit breaker will sleep 
	 * 				in milliseconds before becoming active again.
	 * @return
	 * @throws RestClientException
	 * @throws URISyntaxException
	 */
	@HystrixCommand(fallbackMethod = "getMovieInfoFallback",
				commandProperties = {
						@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
						@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
						@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
						@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")})
	public String getInfo() throws RestClientException, URISyntaxException {
		return restTemplate.getForObject(new URI("http://MOVIE-INFO-SERVICE/movie/info"), String.class);
	}
	
	@SuppressWarnings("unused")
	private String getMovieInfoFallback() {
		return "<h1>CURRENTLY MOVIE INFO SERVICE IS UNAVAILABLE! FALLING BACK FROM HYSTRIX!</h1>";
	}
	
}
