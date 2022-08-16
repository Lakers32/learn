package com.example.learn.spring.threadSafe;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/component123")
@RestController
@Slf4j
public class ComponentFieldController {
    // 私有变量counter
    private Integer counter = 0;

    @GetMapping("/field")
    public String field() {
        counter++;

        // 分别打印线程 ID、counter 值
        log.info("thread: {}, counter value: {}", Thread.currentThread().getId(), counter);

        return "asdfpoiu";
    }
}
