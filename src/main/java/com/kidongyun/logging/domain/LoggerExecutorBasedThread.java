package com.kidongyun.logging.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoggerExecutorBasedThread extends Thread {
    @Override
    public void run() {
        new Logger().heavyLog();
    }

    public static LoggerExecutorBasedThread getInstance() {
        return new LoggerExecutorBasedThread();
    }
}
