package com.example.learn.jvm;

public class CPU100 {

    public static void main(String[] args) {
        int num = 12;
        Thread[] threads = new Thread[num];
        for (int i = 0; i < num; i++) {
            threads[i] = new Thread(new PressureRunner());
            threads[i].start();
        }
    }

    public static class PressureRunner implements Runnable {
        @Override
        public void run() {
            while (true) {

            }
        }
    }

}
