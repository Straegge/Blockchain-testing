package com.the_pangaea_paradigm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {


    public static void main(String[] args) {
//        ProcessBuilder builder = new ProcessBuilder("docker-compose", "up").inheritIO();
//        try {
//            builder.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        SpringApplication.run(Application.class, args);
    }

}
