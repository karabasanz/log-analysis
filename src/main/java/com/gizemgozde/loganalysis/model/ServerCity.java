package com.gizemgozde.loganalysis.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author gizem
 */
public enum ServerCity {

    Istanbul,
    Tokyo,
    Moscow,
    Beijing,
    London;


    private static final List<ServerCity> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static ServerCity randomCity() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
