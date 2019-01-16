package com.ai.sync;
/**
 * 
 * @author Admin
 * synchronized的对象锁和static synchronized的类锁，是两个不同的锁，所以不会同步
 * 两个线程，一个调用对象锁，一个调用类锁
 */
public class SynchronizedTest5 {
    public synchronized  void methodA() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("methodA-" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
    public synchronized static void methodB() {
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
        final SynchronizedTest5 test5 = new SynchronizedTest5();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test5.methodA();
            }
        });
        thread1.start();
 
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test5.methodB();
            }
        });
        thread2.start();
    }
}