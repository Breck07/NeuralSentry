package com.simplyscan.backend.server.one;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

//IP GEO Service class
@Service 
public class IPGeoService {
    private final RestClient restClient;

    //Inject geoClient into the geo service
    public IPGeoService(@Qualifier("geoClient") RestClient restClient){
        this.restClient = restClient;
    }

    //Geo scan method
    public IpGeoResponseDTO geoScan(IpGeoRequestDTO requestDTO){
        //Return response DTO
        return restClient.get()
            .uri("/{ip}", requestDTO.getIp())
            .retrieve()
            .body(IpGeoResponseDTO.class);
    }
}
