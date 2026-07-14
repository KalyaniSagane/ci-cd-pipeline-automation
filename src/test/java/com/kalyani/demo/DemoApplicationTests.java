package com.kalyani.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

@RestController
class HealthController {

    @GetMapping("/")
    public String home() {
        return "CI/CD Pipeline Automation Demo App is running!";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
