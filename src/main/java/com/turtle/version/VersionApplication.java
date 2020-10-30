package com.turtle.version;

import com.turtle.version.config.ApiVersionHandlerMapping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootApplication
public class VersionApplication {

    public static void main(String[] args) {
        SpringApplication.run(VersionApplication.class, args);
    }

}
