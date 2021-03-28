package com.kidongyun.logging.domain;

import com.kidongyun.logging.aspect.ExecuteLog;
import org.springframework.stereotype.Component;

@Component
public class Logger {
    @ExecuteLog
    public void heavyLog() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
