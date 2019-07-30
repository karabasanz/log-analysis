package com.gizemgozde.loganalysis;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Map;

/**
 * @author gizem
 */
@Component
public class LogWatchService {

    private WatchService watchService;
    private Map<WatchKey, Path> keys;

    public LogWatchService() throws Exception {
//        watchService
//            = FileSystems.getDefault().newWatchService();
//
//        Path path = Paths.get("/home/gizem/dev/nunoc/log-analysis/log");
//
//        path.register(
//            watchService,
//            StandardWatchEventKinds.ENTRY_CREATE,
//            StandardWatchEventKinds.ENTRY_DELETE,
//            StandardWatchEventKinds.ENTRY_MODIFY);
//
//        WatchKey key;
//        while ((key = watchService.take()) != null) {
//            for (WatchEvent<?> event : key.pollEvents()) {
//                System.out.println(
//                    "Event kind:" + event.kind()
//                        + ". File affected: " + event.context() + ".");
//            }
//            key.reset();
//        }

        FileAlterationObserver observer = new FileAlterationObserver("/home/gizem/dev/nunoc/log-analysis/log");
        FileAlterationMonitor monitor = new FileAlterationMonitor(200);
        FileAlterationListener listener = new FileAlterationListenerAdaptor() {
            @Override
            public void onFileCreate(File file) {
                System.out.println("file created "+ file.getAbsolutePath());
                // code for processing creation event
            }

            @Override
            public void onFileDelete(File file) {
                System.out.println("file deleted "+ file.getAbsolutePath());
                // code for processing deletion event
            }

            @Override
            public void onFileChange(File file) {
                System.out.println("file changed "+ file.getAbsolutePath());
                // code for processing change event
            }
        };
        observer.addListener(listener);
        monitor.addObserver(observer);
        monitor.start();
    }
}
