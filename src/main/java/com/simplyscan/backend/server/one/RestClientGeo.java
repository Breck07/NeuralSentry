package com.simplyscan.backend.server.one;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration 
public class RestClientGeo {

    @Bean(name = "geoClient")
    public RestClient restClient() { // Removed the Builder parameter
        return RestClient.builder()
            .baseUrl("http://ip-api.com/json")
            .build();
    }
}

