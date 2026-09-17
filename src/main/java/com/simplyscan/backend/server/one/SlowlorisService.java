package com.simplyscan.backend.server.one;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

//Serivce class for Slowloris
@Service
public class SlowlorisService {

    public SlowlorisService(){
    }

    //Method to conduct the slowloris http stress test
    public SlowlorisResponseDTO slowlorisTest(SlowlorisRequestDTO requestDTO){
        //Initilaze resposne dto, response list, and commands
        SlowlorisResponseDTO responseDTO = new SlowlorisResponseDTO();
        List<String> response = new ArrayList<>();
        ArrayList<String> commands = buildCommands(requestDTO.getHost());

        try{
            //Build and start the processe
            ProcessBuilder pb = new ProcessBuilder(commands);
            Process slowlorisProcess = pb.start();

            //Initialize buffered reader to read input stream from the process
            BufferedReader br = new BufferedReader(new InputStreamReader(slowlorisProcess.getInputStream()));
            String line;

            //Loop through and store each line into the resposne list
            while((line = br.readLine()) != null){
                response.add(line);
            }

            //Store response string into DTO for secure parsing into the controller
            responseDTO.setResponse(response);
            return  responseDTO; //Returns the responseDTO

        }catch(Exception e){
            response.add("Error conducting the slowloris test!");
            responseDTO.setResponse(response);
            return responseDTO;
        }
    }
    private ArrayList<String> buildCommands(String host){
        ArrayList<String> commands = new ArrayList<>();
        commands.add("slowloris");
        commands.add(host);

        return commands;
    }

}
