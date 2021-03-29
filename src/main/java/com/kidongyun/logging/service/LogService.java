package com.kidongyun.logging.service;

import com.kidongyun.logging.domain.AsyncExecutor;
import com.kidongyun.logging.domain.Logger;
import com.kidongyun.logging.domain.loggerBasedEvent.EventQueue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LogService {
    private final Logger logger;
    private final AsyncExecutor executor;

    public void loggingBasedSync() {
        logger.logging();
    }

    public void loggingBasedAsync() {
        executor.execute(logger::logging);
    }

    public void loggingBasedEvent() {
        EventQueue.getInstance().add("LOG");
    }
}
