package com.example.learn.spring.threadSafe;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RequestMapping("/component")
@RestController
@Slf4j
public class ComponentFieldAtomController {

    private AtomicInteger counter = new AtomicInteger(0); // Atomic Integer

    @GetMapping("/field")
    public String test() {

        log.info("thread: {}, counter value: {}", Thread.currentThread().getId(), counter.incrementAndGet());

        return "asdfpoiu";
    }
}