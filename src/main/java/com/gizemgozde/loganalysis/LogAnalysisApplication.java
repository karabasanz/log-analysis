package com.gizemgozde.loganalysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

@SpringBootApplication
@EnableScheduling
public class LogAnalysisApplication {


    public static void main(String[] args) {
        SpringApplication.run(LogAnalysisApplication.class, args);
    }

}
