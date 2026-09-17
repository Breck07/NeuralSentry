package com.simplyscan.backend.server.one;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service 
public class OllamaService {
    private RestClient restClient;

    //Create rest client and initialize url
    public OllamaService(){
        this.restClient = RestClient.builder()
            .baseUrl("http://localhost:11434")
            .build();
    }

    //Send request with payload
    public String sendPrompt(OllamaRequest request){
        request.setStream(false);
        OllamaResponse dto = this.restClient.post()
            .uri("/api/generate")
            .header("Content-Type", "application/json")
            .body(request)
            .retrieve()
            .body(OllamaResponse.class);
        
        return dto.getResponse();
    }


}
