package com.kidongyun.logging.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoggerBasedThread extends Thread {
    @Override
    public void run() {
        heavyLogging();
    }

    private void heavyLogging() {
        long start = System.currentTimeMillis();

        try {
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            log.info("Thread ID : " + this.hashCode() + " Logging Finish Time : " + (System.currentTimeMillis() - start));
        }
    }
}
