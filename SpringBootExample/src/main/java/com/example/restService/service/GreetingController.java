package com.example.restService.service;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.logging.log4j.LogManager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restService.dto.Greeting;

@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	org.apache.logging.log4j.Logger logger = LogManager.getLogger();
	
	public GreetingController() {
		System.out.println("GreetingController constructor");
		logger.info("GreetingController constructor");
	}
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
