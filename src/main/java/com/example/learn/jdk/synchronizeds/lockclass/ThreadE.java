package com.example.learn.jdk.synchronizeds.lockclass;

public class ThreadE extends Thread {
    private Task mTask;

    public ThreadE(Task tk) {
        mTask = tk;
    }

    @Override
    public void run() {
        mTask.doLongTimeTaskD();
    }
}
