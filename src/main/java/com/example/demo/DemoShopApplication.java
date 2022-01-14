package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
@EnableFeignClients
@EnableResourceServer
@EnableEurekaClient
public class DemoShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoShopApplication.class, args);
    }

}
