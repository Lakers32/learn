package com.example.learn.jdk.synchronizeds.lockclass;

public class ThreadD extends Thread {
    private Task mTask;

    public ThreadD(Task tk) {
        mTask = tk;
    }

    @Override
    public void run() {
        mTask.doLongTimeTaskD();
    }
}
