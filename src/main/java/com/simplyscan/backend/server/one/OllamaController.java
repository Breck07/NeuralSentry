package com.simplyscan.backend.server.one;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
public class OllamaController {

    //Initialize OllamaService class
    private OllamaService service;

    //Inject service into controller class
    public OllamaController(OllamaService service){
        this.service = service;
    }

    //Set endpoint
    @PostMapping("/ai")
    public String callAI(@RequestBody String prompt) {
        OllamaRequest request = new OllamaRequest();
        request.setModel("qwen2.5:3b"); //If using off my github, ensure model is correct
        request.setPrompt(prompt);
        request.setStream(false);

        return service.sendPrompt(request);

    }
    

}
