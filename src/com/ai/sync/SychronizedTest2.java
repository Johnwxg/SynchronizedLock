package com.ai.sync;

/**
 * 
 * @author Admin
 * 作用在同一个实例对象上讨论
 * Sychronized代码块的测试
 * 两个线程，一个线程执行synchronized代码块，另一个线程执行非synchronized代码块
 */
public class SychronizedTest2 {
    public void methodA() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("methodA-" + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
 
        }
    }
 
    public void methodB() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("methodB-" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
    public static void main(String[] args) {
        final SychronizedTest2 test2 = new SychronizedTest2();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
               test2.methodA();
            }
        });
        thread1.start();
 
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test2.methodB();
            }
        });
        thread2.start();
    }
}