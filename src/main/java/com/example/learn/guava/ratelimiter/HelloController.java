package com.example.learn.guava.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: 程凯
 * @create: 2022-10-12 21:44
 **/
@Controller
public class HelloController {

    /**
     * 限流策略 ： 限制每秒最多1个请求
     */
    private final RateLimiter limiter = RateLimiter.create(1.0);
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @RequestMapping("/access")
    @ResponseBody
    public String access() throws InterruptedException {

        while (true) {
            //500毫秒内，没拿到令牌，就直接进入服务降级
            while (!limiter.tryAcquire(500, TimeUnit.MILLISECONDS)) {
                System.out.println("sleep");
                Thread.sleep(500);
            }
            System.out.println("send to es");
        }

    }
}
