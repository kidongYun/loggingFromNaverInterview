package com.kidongyun.logging.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AsyncExecutor {
    private int count = 0;

    public void execute(Runnable runnable) {
        setCount(++this.count);

        new Thread(runnable).start();

        setCount(--this.count);
    }

    public static AsyncExecutor getInstance() {
        return new AsyncExecutor();
    }

    private synchronized void setCount(int count) {
        log.info("count - " + count);
        this.count = count;
    }
}
