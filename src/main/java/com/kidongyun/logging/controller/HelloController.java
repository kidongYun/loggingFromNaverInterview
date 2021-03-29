package com.kidongyun.logging.controller;

import com.kidongyun.logging.domain.AsyncExecutor;
import com.kidongyun.logging.service.LogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/hello")
@RequiredArgsConstructor
public class HelloController {
    private final LogService logService;

    @GetMapping("/sync")
    public ResponseEntity<?> helloSync() {
        long startTime = System.currentTimeMillis();

        for(int i=0; i<100; i++) {
            logService.loggingBasedSync();
        }

        Runtime.getRuntime().gc();
        log.info("Memory Usage : " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
        log.info("Execute Time : " + (System.currentTimeMillis() - startTime));
        return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK.getReasonPhrase());
    }

    @GetMapping("/async")
    public ResponseEntity<?> helloAsync() {
        long startTime = System.currentTimeMillis();

        for(int i=0; i<100; i++) {
            logService.loggingBasedAsync();
        }

        while(!AsyncExecutor.isStopped()) { }

        Runtime.getRuntime().gc();
        log.info("Memory Usage : " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
        log.info("Execute Time : " + (System.currentTimeMillis() - startTime));
        return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK.getReasonPhrase());
    }

    @GetMapping("/asyncWithPool")
    public ResponseEntity<?> helloAsyncWithPool() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        Thread thread1 = new Thread(() -> {
            try {
                for(int i=0; i<5; i++) {
                    Thread.sleep(1000);
                    log.info("Thread 1 - " + i);
                }

                notify();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                for(int i=0; i<5; i++) {
                    Thread.sleep(1000);
                    log.info("Thread 2 - " + i);
                }

                notify();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        log.info("Execute Time : " + (System.currentTimeMillis() - startTime));
        return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK.getReasonPhrase());
    }

    @GetMapping("/basedEvent")
    public ResponseEntity<?> helloBasedEvent() {
        long startTime = System.currentTimeMillis();

        logService.loggingBasedEvent();

        log.info("Execute Time : " + (System.currentTimeMillis() - startTime));
        return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK.getReasonPhrase());
    }
}
