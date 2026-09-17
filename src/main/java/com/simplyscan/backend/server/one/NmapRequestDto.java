package com.simplyscan.backend.server.one;

public class NmapRequestDto {
    private String ip;
    
    public NmapRequestDto(){

    }

    public void setIp(String ip){
        this.ip = ip;
    }
    public String getIp(){
        return ip;
    }
    
}
