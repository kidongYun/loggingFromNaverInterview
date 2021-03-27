package com.kidongyun.logging.domain.loggerBasedEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventRunner implements ApplicationRunner {
    private final EventListener eventListener;

    @Override
    public void run(ApplicationArguments args) {
//        log.info("EventListener is launching...");
//        eventListener.on();
    }
}
