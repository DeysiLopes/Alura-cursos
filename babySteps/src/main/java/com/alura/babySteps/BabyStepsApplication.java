package com.alura.babySteps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class BabyStepsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BabyStepsApplication.class, args);
    }

}
