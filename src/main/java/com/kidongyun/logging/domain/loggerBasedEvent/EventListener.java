package com.kidongyun.logging.domain.loggerBasedEvent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventListener extends Thread {
    private boolean flag = true;

    @Override
    public void run() {
        try {
            while(flag) {
                Thread.sleep(1000);
                log.info("EventListener is listening...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void on() {
        this.flag = true;
        this.start();
    }

    public void off() {
        this.flag = false;
    }
}
