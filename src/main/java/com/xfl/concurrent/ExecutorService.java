package com.xfl.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by XFL
 * time on 2017/5/14 23:32
 * description:jdk自带线程池
 */
public class ExecutorService {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
    }
}
