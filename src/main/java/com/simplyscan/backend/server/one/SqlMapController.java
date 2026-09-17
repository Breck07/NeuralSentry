package com.simplyscan.backend.server.one;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SqlMapController {

    //Inject Service
    private SqlMapService service;

    public SqlMapController(SqlMapService service){
        this.service = service;
    }

    //Initialize post endpoint
    @PostMapping("/sqlMap")

    public List<String> sqlMap(@RequestBody SqlMapDto dto){
        //Store results from sql scan service
        List<String> results = service.runScan(dto);
        return results;
    }
}
