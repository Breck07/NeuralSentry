package com.simplyscan.backend.server.one;

//DTO class for ollama response
public class OllamaResponse {
    public OllamaResponse(){

    }

    private String response;

    //Getteres and Setters
    public void setResponse(String response){
        this.response = response;
    }
    public String getResponse(){
        return response;
    }
}
