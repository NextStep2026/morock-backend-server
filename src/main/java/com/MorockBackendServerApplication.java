package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com"})
public class MorockBackendServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MorockBackendServerApplication.class, args);
    }

}
