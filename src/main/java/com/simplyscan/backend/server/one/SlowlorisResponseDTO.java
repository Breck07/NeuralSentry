package com.simplyscan.backend.server.one;

import java.util.List;

public class SlowlorisResponseDTO {
    private List<String> response;

    public SlowlorisResponseDTO(){

    }

    //Getters and Setters
    public void setResponse(List<String> repsonse){
        this.response = repsonse;
    }
    public List<String> getResponse(){
        return response;
    }

    

}
