package com.simplyscan.backend.server.one;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
public class NucleiController {
    //Initialize the nuclei service
    private NucleiService nucleiService;

    //Inject service into the controller
    public NucleiController(NucleiService nucleiService){
        this.nucleiService = nucleiService;
    }

    //Create POST endpoint for nuclei
    @PostMapping("/nuclei")
    public String postMethodName(@RequestBody String host) {
        //Initialze DTO for request data
        NucleiRequestData dto = new NucleiRequestData();
        dto.setHost(host); //Set host to host

        return nucleiService.nucleiScan(dto).toString(); //Return results as string
    }
    
    

}
