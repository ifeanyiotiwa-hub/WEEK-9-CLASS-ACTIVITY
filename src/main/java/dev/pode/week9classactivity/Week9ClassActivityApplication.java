package dev.pode.week9classactivity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import java.beans.BeanProperty;

@SpringBootApplication
public class Week9ClassActivityApplication {

    @Bean
    WebClient getWebClient(){
        return WebClient.create();
    }

    @Bean
    WebClient.Builder getWebClients(){
        return WebClient.builder();

    }

    public static void main(String[] args) {
        SpringApplication.run(Week9ClassActivityApplication.class, args);
    }

}
