package com.example.learn.guava.ratelimiter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: 程凯
 * @create: 2022-10-12 21:44
 **/
@Controller
public class HelloController {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private AccessLimitService accessLimitService;

    @RequestMapping("/access")
    @ResponseBody
    public String access() {
        //尝试获取令牌
        if (accessLimitService.tryAcquire()) {
            //模拟业务执行500毫秒
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "aceess success [" + sdf.format(new Date()) + "]";
        } else {
            return "aceess limit [" + sdf.format(new Date()) + "]";
        }
    }
}
