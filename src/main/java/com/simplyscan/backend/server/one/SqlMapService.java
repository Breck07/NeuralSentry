package com.simplyscan.backend.server.one;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class SqlMapService {
    public List<String> runScan(SqlMapDto dto){
        List<String> results = new ArrayList<>();

        //Set host and build commands
        String host = dto.getHost();

        List<String> commands = buildCommands(host);

        //Build and run process
        ProcessBuilder pb = new ProcessBuilder(commands);

        //Try to run sqlmap scan on host
        try {
            Process sqlMap = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(sqlMap.getInputStream()));

            String line;

            //Read sqlmap output
            while((line = br.readLine()) != null){
                results.add(line);
            }

        } catch (Exception e) {
            
            //Handle the error
            results.add("Error launching sqlmap scan!");
        }

        return results;

    }

    private List<String> buildCommands(String host){
        List<String> commands = new ArrayList<>();
        commands.add("sqlmap");
        commands.add("-u");
        commands.add(host);
        commands.add("--batch");
        commands.add("--banner");

        return commands;
    }
}
