package com.gizemgozde.loganalysis.controller;

import com.gizemgozde.loganalysis.service.LogCreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gizem
 */
@RestController
@RequestMapping(path = "/api/log")
public class LogController {

    private LogCreatorService logCreatorService;

    @Autowired
    public LogController(LogCreatorService logCreatorService) {
        this.logCreatorService = logCreatorService;
    }

    @GetMapping("/write")
    public void writeLog(Integer logCount) {
        logCreatorService.writeLogToFile();


    }
}
