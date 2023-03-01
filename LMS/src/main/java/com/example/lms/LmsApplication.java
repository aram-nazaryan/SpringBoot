package com.example.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LmsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(LmsApplication.class, args);
    }

}
