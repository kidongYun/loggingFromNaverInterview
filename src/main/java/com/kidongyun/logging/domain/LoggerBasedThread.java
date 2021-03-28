package com.kidongyun.logging.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoggerBasedThread extends Thread {
    @Override
    public void run() {
        long start = System.currentTimeMillis();

        heavyLog();

        log.info("Thread ID : " + this.hashCode() + " Logging Finish Time : " + (System.currentTimeMillis() - start));
    }

    public static LoggerBasedThread getInstance() {
        return new LoggerBasedThread();
    }

    private void heavyLog() {
        try {
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
