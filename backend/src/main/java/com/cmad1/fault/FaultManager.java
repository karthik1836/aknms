package com.cmad1.fault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application start for fault processor
 *
 */
@SpringBootApplication
public class FaultManager 
{
    public static void main( String[] args )
    {
        SpringApplication.run(FaultManager.class, args);
    }
}
