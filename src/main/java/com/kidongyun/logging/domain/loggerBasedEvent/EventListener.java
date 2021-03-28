package com.kidongyun.logging.domain.loggerBasedEvent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
@Component
public class EventListener extends Thread {
    private static Queue<String> eventQueue = new LinkedList<>();

    @Override
    public void run() {
        try {
            while(true) {
                Thread.sleep(2000);
                if(eventQueue.isEmpty()) {
                    continue;
                }

                if("LOG".equals(eventQueue.peek())) {
                    Thread.sleep(2000);
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
