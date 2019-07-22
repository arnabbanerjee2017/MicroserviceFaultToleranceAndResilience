/*
 * Copyright (c) 2019, ARNAB BANERJEE. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted only for academic purposes.
 * 
 * For further queries / info: arnab.ban09@gmail.com
 */

package com.arnab.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arnab.spring.service.MovieCatalogService;

@RestController
@RequestMapping(value = "/movie")
public class MovieCatalogController {

	@Autowired
	private MovieCatalogService service;
	
	@GetMapping(value = "/catalog", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getMovie() {
		return service.getMovieCatalog();
	}
	
}
