package com.kidongyun.logging.domain.loggerBasedEvent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        log.info("EventListener is launching...");
        EventListener.getInstance().start();
    }
}
