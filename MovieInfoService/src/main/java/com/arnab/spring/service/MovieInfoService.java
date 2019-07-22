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

@Service
public class MovieInfoService {
	
	@Autowired
	private RestTemplate restTemplate;

	public String getMovieInfo() throws RestClientException, URISyntaxException {
		return restTemplate.getForObject(new URI("https://api.themoviedb.org/3/movie/550?api_key=81742d1fe31c0b1e58600782fb5a5e9e"), String.class);
	}
	
}
