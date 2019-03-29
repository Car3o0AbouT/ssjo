package com.demo.ssjo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author lec
 */
@SpringBootApplication
@EnableJpaAuditing
public class SsjoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsjoApplication.class, args);
    }

}

