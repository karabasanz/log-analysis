package com.gizemgozde.loganalysis.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author gizem
 */
public enum LogLevel {

    WARN,
    INFO,
    ERROR,
    DEBUG,
    FATAL;

    private static final List<LogLevel> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static LogLevel randomLogLevel() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

}
