package com.kidongyun.logging.domain.loggerBasedEvent;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

@Component
public class EventQueue {
    private Queue<String> queue = new LinkedList<>();

    public void add(String value) {
        queue.add(value);
    }
}
