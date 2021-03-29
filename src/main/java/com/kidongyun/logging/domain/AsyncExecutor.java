package com.kidongyun.logging.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AsyncExecutor {
    private static int EXECUTED_THREAD_COUNT = 0;

    public void execute(Runnable runnable) {
        new Thread(() -> {
            countUp();
            runnable.run();
            countDown();
        }).start();
    }

    public static AsyncExecutor getInstance() {
        return new AsyncExecutor();
    }

    private static synchronized void countUp() {
        ++EXECUTED_THREAD_COUNT;
    }

    private static synchronized void countDown() {
        --EXECUTED_THREAD_COUNT;
    }

    public static boolean isStopped() {
        if(EXECUTED_THREAD_COUNT == 0) {
            return true;
        }

        return false;
    }
}
