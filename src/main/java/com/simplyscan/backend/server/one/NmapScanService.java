package com.simplyscan.backend.server.one;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

//Nmap service class
@Service
public class NmapScanService {
    public NmapScanService(){

    }

    //Method to run nmap process/scan
    public NmapResponse runScan(NmapRequestDTO nmapRequestDto){
        String ip = nmapRequestDto.getHost();

        //Initialize list for results and commands
        List<String> results = new ArrayList<>();
        List<String> commands = new ArrayList<>();

        //Add commands to command list
        commands.add("nmap");
        commands.add(ip);

        ProcessBuilder pb = new ProcessBuilder(commands);
        
        //Try to run process and capture the output
        try{
            Process scanner = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(scanner.getInputStream()));

            String line;

            while((line = br.readLine()) != null){
                results.add(line);
            }

        }catch(Exception e){
            //Handle errors
            results.add("Error with nmap scan!");
        }

        String response = results.toString(); 
        
        //Return results
        NmapResponse responseDTO = new NmapResponse();
        responseDTO.setResponse(response);

        return responseDTO;
    }

}
