/*
 * Copyright (c) 2019, ARNAB BANERJEE. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted only for academic purposes.
 * 
 * For further queries / info: arnab.ban09@gmail.com
 */

package com.arnab.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MovieInfoConfig {

	@Bean
	public RestTemplate getRestTemplate() {
		/**
		 * This is the first way to timeout a request. It is just a simple case and not a preferred way.
		 * To test it, just uncomment and run. But this is commented because the timeout is being handled from the 
		 * MovieServiceClient application - the main client application.
		 */
		/*
		 * HttpComponentsClientHttpRequestFactory factory = new
		 * HttpComponentsClientHttpRequestFactory(); factory.setConnectTimeout(30);
		 * return new RestTemplate(factory);
		 */
		
		return new RestTemplate();
		
	}
	
}
