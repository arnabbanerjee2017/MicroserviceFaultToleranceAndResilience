/*
 * Copyright (c) 2019, ARNAB BANERJEE. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted only for academic purposes.
 * 
 * For further queries / info: arnab.ban09@gmail.com
 */

package com.arnab.spring.service;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

/**
 * This is the main Service class.
 * @author Arnab
 *
 */
@Service
public class MovieService {	
	
	/**
	 * This is @Autowired MovieClass object. This will be actually a Hystrix proxy class which handles the fallback mechanism.
	 */
	@Autowired
	private MovieCatalog movieCatalog;
	
	/**
	 * This is @Autowired MovieInfo object. This will be actually a Hystrix proxy class which handles the fallback mechanism.
	 */
	@Autowired
	private MovieInfo movieInfo;
	
	public String getMovieCatalog() throws RestClientException, URISyntaxException {
		return movieCatalog.getCatalog();
	}	
	
	public String getMovieInfo() throws RestClientException, URISyntaxException {
		return movieInfo.getInfo();
	}
	
}
