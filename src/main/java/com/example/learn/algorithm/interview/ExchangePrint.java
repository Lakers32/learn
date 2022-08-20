package com.example.learn.algorithm.interview;

public class ExchangePrint {

    private static int count = 1;
    private static Object object = new Object();

    public static void main(String[] args) {
        new Thread(new MyThread()).start();
        new Thread(new MyThread()).start();

    }


    static class MyThread implements Runnable {
        @Override
        public void run() {
            while (count <= 100) {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName()+ ": " + count++);
                    // 通知另外一个线程
                    object.notify();
                    // 通知其他线程
                    if(count <= 100) {
                        try{
                            object.wait();
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
