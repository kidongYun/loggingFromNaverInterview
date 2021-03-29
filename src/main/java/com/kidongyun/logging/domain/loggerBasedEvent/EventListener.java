package com.kidongyun.logging.domain.loggerBasedEvent;

import com.kidongyun.logging.domain.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventListener extends Thread {
    @Override
    public void run() {
        try {
            while(true) {
                log.info("EventListener is listening...");
                Thread.sleep(2000);

                if(EventQueue.getInstance().isEmpty()) {
                    continue;
                }

                if("LOG".equals(EventQueue.getInstance().poll())) {
                    new Logger().logging();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static EventListener getInstance() {
        return new EventListener();
    }
}
