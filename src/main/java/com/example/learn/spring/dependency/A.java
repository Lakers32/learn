package com.example.learn.spring.dependency;

/**
 * @ClassName: A
 * @Description: TODO
 * @Author: kotchen
 * @Date: 2021/4/23 10:27
 * @Version: 1.0
 **/
public class A {

    private B b;

    public B getB() {
        return new B();
    }
}
