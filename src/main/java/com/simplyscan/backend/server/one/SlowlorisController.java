package com.simplyscan.backend.server.one;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


//Controller class for slowloris endpoint
@RestController 
public class SlowlorisController {
    private SlowlorisService service;

    //Inject service into the controller
    public SlowlorisController(SlowlorisService service){
        this.service = service;
    }

    //EndPoint for controller
    @PostMapping("/slowloris")
    public SlowlorisResponseDTO postMethodName(@RequestBody SlowlorisRequestDTO requestDTO) {
        return service.slowlorisTest(requestDTO);
    }
    

}
