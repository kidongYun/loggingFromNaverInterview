package com.kidongyun.logging.controller;

import com.kidongyun.logging.aspect.ExecuteLog;
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

        for(int i=0; i<1000; i++) {
            logService.loggingBasedAsync();
        }

        log.info("Execute Time : " + (System.currentTimeMillis() - startTime));
        log.info("Memory Usage : " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
        return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK.getReasonPhrase());
    }

    @GetMapping("/basedThread")
    public ResponseEntity<?> helloBasedThread() {
        long startTime = System.currentTimeMillis();

        logService.loggingBasedAsync();

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
