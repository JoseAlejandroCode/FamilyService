package com.microservice.family.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ServiceConfig {

  @Value("${config.base.service.uri}")
  private String pathStudent;

  @Bean
  public WebClient registrarWebClient(){
    return WebClient.create(pathStudent);
  }

}
