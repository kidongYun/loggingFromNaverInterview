package com.kidongyun.logging.domain;

import com.kidongyun.logging.aspect.ExecuteLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Logger {

    public void logging() {
        long startTime = System.currentTimeMillis();

        heavyLog();

        log.info("Execute Time : " + (System.currentTimeMillis() - startTime));
    }

    public void heavyLog() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
