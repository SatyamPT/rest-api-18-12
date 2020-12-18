package com.ssi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssi.service.SampleService;

@RestController
public class SampleController {

	@Autowired
	private SampleService sampleService;
	
	
	@RequestMapping(value="/now")
	public String getCurrentDateAndTime() {
		return sampleService.getServerTime();
	}
	
	
}
