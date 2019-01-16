package com.ai.sync;

/**
 * 
 * @author Admin
 * 作用在同一个实例对象上讨论
 * Synchronized同步方法和同步代码块
 * 1、synchronized和synchronized（this）二者没区别，都作用在this对象锁上面，所以会同步
 * 2、synchronized（obj），这个是作用在obj对象锁上面，和this对象锁不同，所以不会同步
 */
public class SynchronizedTest3 {
    public synchronized void methodA() {
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
        synchronized (this) {
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
 
    public void methodC() {
        Object obj = new Object();
        synchronized (obj) {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("methodC-" + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
 
    public static void main(String[] args) {
        final SynchronizedTest3 test3 = new SynchronizedTest3();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test3.methodA();
            }
        });
        thread1.start();
 
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test3.methodB();
            }
        });
        thread2.start();
 
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                test3.methodC();
            }
        });
        thread3.start();
 
    }
}