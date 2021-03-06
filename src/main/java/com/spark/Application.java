package com.spark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by tyd on 2018-1-15.
 */
@SpringBootApplication
@ComponentScan("com.spark")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
