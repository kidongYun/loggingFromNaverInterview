package com.kidongyun.logging.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Logger {

    public void logging() {
        long startTime = System.currentTimeMillis();

        heavyLog();

        log.info("Logging Execute Time : " + (System.currentTimeMillis() - startTime));
    }

    private void heavyLog() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
