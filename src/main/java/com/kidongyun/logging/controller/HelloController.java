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

    @ExecuteLog
    @GetMapping("/basedThread")
    public ResponseEntity<?> helloBasedThread() {
        logService.loggingBasedThread();
        return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK.getReasonPhrase());
    }

    @ExecuteLog
    @GetMapping("/basedEvent")
    public ResponseEntity<?> helloBasedEvent() {
        logService.loggingBasedEvent();
        return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK.getReasonPhrase());
    }
}
