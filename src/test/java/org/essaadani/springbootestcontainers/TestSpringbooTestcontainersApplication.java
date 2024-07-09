package org.essaadani.springbootestcontainers;

import org.springframework.boot.SpringApplication;

public class TestSpringbooTestcontainersApplication {

    public static void main(String[] args) {
        SpringApplication.from(SpringbooTestcontainersApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
