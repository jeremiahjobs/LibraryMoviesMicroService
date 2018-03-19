package com.jeremiah.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * main method in order to start the REST microservice application
 * @author Jeremiah 
 *
 */
@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
	}

}
