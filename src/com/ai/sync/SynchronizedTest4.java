package com.ai.sync;

/**
 * 
 * @author Admin
 * 作用在同一个类上讨论，每一个类只有一个类锁
 * synchronized类锁
 * static synchronized 和 synchronized（SynchronizedTest4.class）,都是作用在同一个类锁上，所以会同步
 */
public class SynchronizedTest4 {
    public synchronized static void methodA() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("methodA-" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
    public void methodB() {
        synchronized (SynchronizedTest4.class) {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("methodB-" + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
 
    public static void main(String[] args) {
        final SynchronizedTest4 test4 = new SynchronizedTest4();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test4.methodA();
            }
        });
        thread1.start();
 
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test4.methodB();
            }
        });
        thread2.start();
    }
}
