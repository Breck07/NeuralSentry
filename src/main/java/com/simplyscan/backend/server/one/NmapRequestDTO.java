package com.simplyscan.backend.server.one;

public class NmapRequestDTO {
    private String host;

    public NmapRequestDTO(){

    }

    //Getters and Setters
    public void setHost(String host){
        this.host = host;
    }
    public String getHost(){
        return host;
    }

}
