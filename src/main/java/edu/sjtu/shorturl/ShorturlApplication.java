package edu.sjtu.shorturl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ShorturlApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ShorturlApplication.class, args);
    }

}
