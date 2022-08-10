package com.alphacode.handson;

import lombok.extern.slf4j.Slf4j;

import org.h2.tools.DeleteDbFiles;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PreDestroy;

@SpringBootApplication
public class HandsonApplication {

    public static void main(String[] args) {
        System.out.println("start project");
        SpringApplication.run(HandsonApplication.class, args);
    }
}

@Slf4j
@Profile("local")
@Configuration
class LocalConfig {

    @PreDestroy
    public void deleteLocalDB() {
        log.info("Start delete local H2 DB..");
        DeleteDbFiles.execute("~/handson", "user", false);
        log.info("Delete local H2 DB");
    }
}
