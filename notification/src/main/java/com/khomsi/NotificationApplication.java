package com.khomsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(
        scanBasePackages = {
                "com.khomsi.notification",
                "com.khomsi.amqp"
        }
)
@EnableDiscoveryClient
@EnableFeignClients
@PropertySources(
        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
)
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

/*    @Bean
    CommandLineRunner commandLineRunner(NotificationConfiguration configuration,
                                        RabbitMQMessageProducer producer) {
        return args -> {
            producer.publish(new Person("Dima", 20),
                    configuration.getInternalExchange(),
                    configuration.getInternalNotificationRoutingKey());
        };
    }

    record Person(String name, int age) {
    }*/
}