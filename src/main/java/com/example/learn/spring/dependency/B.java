package com.example.learn.spring.dependency;

/**
 * @ClassName: B
 * @Description: TODO
 * @Author: kotchen
 * @Date: 2021/4/23 10:27
 * @Version: 1.0
 **/
public class B {

    private A a;

    public A getA() {
        return new A();
    }
}
