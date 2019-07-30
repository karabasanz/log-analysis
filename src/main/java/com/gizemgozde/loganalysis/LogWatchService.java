package com.gizemgozde.loganalysis;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author gizem
 */
@Component
public class LogWatchService {

    private Map<String, Integer> keys;

    public LogWatchService() throws Exception {

        keys = new HashMap<>();

        String directoryName = "log/";
        FileAlterationObserver observer = new FileAlterationObserver(directoryName);
        FileAlterationMonitor monitor = new FileAlterationMonitor(200);
        FileAlterationListener listener = new FileAlterationListenerAdaptor() {
            @Override
            public void onFileCreate(File file) {
                System.out.println("file created " + file.getAbsolutePath());

                readFileLineByLine(file, 1);
            }

            @Override
            public void onFileDelete(File file) {
                System.out.println("file deleted " + file.getAbsolutePath());
                // code for processing deletion event
            }

            @Override
            public void onFileChange(File file) {
                System.out.println("file changed " + file.getAbsolutePath());

                int lineNumber;
                if (keys.get(file.getName()) == null) {
                    System.out.println("lineNumber = 0");
                    lineNumber = 1;
                } else {
                    lineNumber = keys.get(file.getName());
                }

                readFileLineByLine(file, lineNumber);
            }

            private void readFileLineByLine(File file, int lineNumber) {
                boolean finished = false;
                while (!finished) {
                    try {
                        Optional<String> first = Files.lines(Paths.get(directoryName + file.getName())).skip(lineNumber - 1).findFirst();
                        if (first.isPresent()) {
                            String str = first.get();
                            System.out.println(file.getName()+" --- "+"Content at " + lineNumber + " Number:- " + str);
                            lineNumber++;

                        } else {
                            keys.put(file.getName(), lineNumber);
                            finished = true;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        observer.addListener(listener);
        monitor.addObserver(observer);
        monitor.start();
    }
}
