package com.simplyscan.backend.server.one;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//Class for nmap controller
@RestController
public class NmapController {
    private NmapScanService scanner;

    //Inject Nmap Service
    public NmapController(NmapScanService scanner){
        this.scanner = scanner;
    }

    //Create post endpoint for nmap scan
    @PostMapping("/nmap")

    //Method for runnning nmap logic
    public String runNmap(@RequestBody String ip){
        NmapRequestDto dto = new NmapRequestDto();
        dto.setIp(ip);
        return scanner.runScan(dto).toString();
    }
}
