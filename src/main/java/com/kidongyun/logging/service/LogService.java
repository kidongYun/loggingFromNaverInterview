package com.kidongyun.logging.service;

import com.kidongyun.logging.domain.LoggerBasedThread;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LogService {
    private final LoggerBasedThread loggerBasedThread;

    public void logging() {
        loggerBasedThread.start();
    }
}
