package com.simplyscan.backend.server.one;

public class IpGeoRequestDTO {
    private String ip;

    public IpGeoRequestDTO(){

    }

    //Getters and Setters
    public void setIp(String ip){
        this.ip = ip;
    }
    public String getIp(){
        return ip;
    }
}
