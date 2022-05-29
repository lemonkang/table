package com.example.cgtable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class CgtableApplication {
    public static void main(String[] args) {
        SpringApplication.run(CgtableApplication.class, args);
    }

}
