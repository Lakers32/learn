package com.example.learn.spring.threadSafe;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/component")
@RestController
@Slf4j
public class ComponentFieldThreadLocalController {

    private ThreadLocal<Integer> counter = ThreadLocal.withInitial(() -> 0); // 线程单独变量

    @GetMapping("/field123")
    public String test() {
        counter.set(counter.get() + 1);

        log.info("thread: {}, counter value: {}", Thread.currentThread().getId(), counter.get());

        return "asdfpoiu";
    }

}
