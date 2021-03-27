package com.kidongyun.logging.service;

import com.kidongyun.logging.domain.Logger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LogService {
    private final Logger logger;

    public void logging() {
        logger.start();
    }
}
