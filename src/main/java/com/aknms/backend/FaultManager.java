package com.aknms.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application start for fault processor
 *
 */
@SpringBootApplication
public class FaultManager {
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(15000L);
		SpringApplication.run(FaultManager.class, args);
	}
}
