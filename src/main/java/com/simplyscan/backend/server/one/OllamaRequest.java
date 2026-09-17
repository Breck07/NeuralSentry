package com.simplyscan.backend.server.one;


//DTO class for ollama request
public class OllamaRequest {
    public OllamaRequest(){

    }

    private String prompt;
    private String model;
    private boolean stream;

    //Getteres and Setters
    public void setPrompt(String prompt){
        this.prompt = prompt;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setStream(boolean stream){
        this.stream = stream;
    }
    public String getPrompt(){
        return prompt;
    }
    public String getModel(){
        return model;
    }
    public boolean getStream(){
        return stream;
    }
}
