package com.khomsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(
        scanBasePackages = {"com.khomsi.customer",
                "com.khomsi.amqp"}
)
@EnableDiscoveryClient
@EnableFeignClients(
        basePackages = "com.khomsi.clients"
)
@PropertySources(
        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
)
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
