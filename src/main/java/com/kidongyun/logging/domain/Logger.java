package com.kidongyun.logging.domain;

import com.kidongyun.logging.aspect.ExecuteLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Logger {
    @ExecuteLog
    public void heavyLog() {
        try {
            Thread.sleep(2000);
            log.info("heavyLog");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
