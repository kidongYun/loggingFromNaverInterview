package com.kidongyun.logging.service;

import com.kidongyun.logging.domain.LoggerBasedThread;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LogService {
    public void logging() {
        LoggerBasedThread.getInstance().start();
    }
}
