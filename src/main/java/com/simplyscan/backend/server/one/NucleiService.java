package com.simplyscan.backend.server.one;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class NucleiService{
    //Service object
    public NucleiService(){
    }

    //Scan method to conduct nuclei scanning
    public List<String> nucleiScan(NucleiRequestData nucleiRequestData){
        //Initialize results list
        List<String> results = new ArrayList<>();

        //Initialzie host and commands
        String host = nucleiRequestData.getHost();
        List<String> commands = buildCommands(host);

        //Initialize ProcessBuilder and try to run nuclei process
        ProcessBuilder pb = new ProcessBuilder(commands);

        try{
            Process nucleipProcess = pb.start();

            //Read output using buffered reader
            BufferedReader reader = new BufferedReader(new InputStreamReader(nucleipProcess.getInputStream()));
            String line;

            while((line = reader.readLine()) != null){
                results.add(line);
            }

            //Display completion and close the reader
            results.add("[Scan Completed!]");
            reader.close();

        }catch(Exception e){
            //Handle error
            results.add("Error occured with nuclei process!");
        }

        return results; //Return the results


    }

    //Method to build commands for nuclei scan
    private List<String> buildCommands(String host){
        List<String> commands = new ArrayList<>();
        commands.add("nuclei");
        commands.add("-target");
        commands.add(host);

        return  commands;
    }
}
