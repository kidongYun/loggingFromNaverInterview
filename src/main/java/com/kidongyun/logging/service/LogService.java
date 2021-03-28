package com.kidongyun.logging.service;

import com.kidongyun.logging.domain.LoggerExecutorBasedThread;
import com.kidongyun.logging.domain.loggerBasedEvent.EventQueue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LogService {
    private final EventQueue eventQueue;

    public void loggingBasedThread() {
        LoggerExecutorBasedThread.getInstance().start();
    }

    public void loggingBasedEvent() {
        eventQueue.add("LOG");
    }
}
