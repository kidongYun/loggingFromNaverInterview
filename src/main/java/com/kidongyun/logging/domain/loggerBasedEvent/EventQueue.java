package com.kidongyun.logging.domain.loggerBasedEvent;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

@Component
public class EventQueue {
    private static Queue<String> queue = new LinkedList<>();

    public static Queue<String> getInstance() {
        return queue;
    }
}
