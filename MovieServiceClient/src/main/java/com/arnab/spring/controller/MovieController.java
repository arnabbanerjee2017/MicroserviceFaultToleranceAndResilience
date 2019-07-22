/*
 * Copyright (c) 2019, ARNAB BANERJEE. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted only for academic purposes.
 * 
 * For further queries / info: arnab.ban09@gmail.com
 */

package com.arnab.spring.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.arnab.spring.service.MovieService;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {

	@Autowired
	private MovieService service;
	
	@GetMapping(value = "/catalog")
	public String getMovieCatalog() throws RestClientException, URISyntaxException {
		return service.getMovieCatalog();
	}
	
	@GetMapping(value = "/info")
	public String getMovieInfo() throws RestClientException, URISyntaxException {
		return service.getMovieInfo();
	}
	
}
