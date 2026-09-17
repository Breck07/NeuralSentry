package com.simplyscan.backend.server.one;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
public class GeoController {
    private final IPGeoService geoService;

    //Inject geo service into controller
    public GeoController(IPGeoService geoService){
        this.geoService = geoService;
    }

    //Map to /geo endpoint
    @PostMapping("/geo")
    //Methof to store main logic for sending request and response
    public IpGeoResponseDTO geoMethod(@RequestBody IpGeoRequestDTO requestDTO) {
        IpGeoResponseDTO responseDTO = geoService.geoScan(requestDTO);
        
        return responseDTO; //Return response
    }
    

}
