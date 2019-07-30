package com.gizemgozde.loganalysis.service;

import com.gizemgozde.loganalysis.LogWatchService;
import com.gizemgozde.loganalysis.model.Log;
import com.gizemgozde.loganalysis.model.LogLevel;
import com.gizemgozde.loganalysis.model.ServerCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gizem
 */
@Service
public class LogCreatorService {

    public static final String FILE_PATH = "log/out.txt";
    public static final int filePathCount = 1;
    int count = 0;

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    @Autowired
    private LogWatchService logWatchService;


    private Log createLog() {

        Log log = new Log();
        log.setCount(++count);
        String timestamp = formatter.format(new Date());
        log.setTimestamp(timestamp);
        log.setCityname(ServerCity.randomCity());
        log.setLevel(LogLevel.randomLogLevel());
        log.setDetail("Hello-from-" + log.getCityname().name());
        return log;
    }

    public void writeLogToFile() {


        if(!checkFileSize(FILE_PATH)){
            // path change
        }
        File fout = new File(FILE_PATH);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fout,true);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
                Log log = createLog();
                System.out.println("count  ---- "+ log.getCount());
                System.out.println("level : " + log.getLevel());
                System.out.println("detail : " + log.getDetail());
                bw.write(log.toString());
                bw.newLine();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkFileSize(String filePath) {
        return false;
    }


}
