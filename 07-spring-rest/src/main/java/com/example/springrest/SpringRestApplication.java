package com.example.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestClient;

@SpringBootApplication
@ComponentScan("com.example")
public class SpringRestApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringRestApplication.class, args);
  }
  @Bean
  public RestClient restClient(RestClient.Builder builder) {
    return builder.build();
  }
}
