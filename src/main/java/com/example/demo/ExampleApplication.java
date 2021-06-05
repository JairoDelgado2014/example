package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleApplication {
	// Define the logger object for this class
	private static final Logger logger = LoggerFactory.getLogger(ExampleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
		logger.info("INFO - Level Log Message"); // Print a Info Logger Msg
		logger.warn("WARN - Level Log Message");// Print a WARN Logger Msg
		logger.error("ERROR - Level Log Message");// Print a ERROR Logger Msg
	}

}
