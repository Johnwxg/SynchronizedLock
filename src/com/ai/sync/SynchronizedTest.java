package com.ai.sync;

/**
 * 
 * @author Admin
 * 作用在同一个实例对象上讨论
 * synchronized同步方法的测试
 * 两个线程，一个线程调用synchronized修饰方法，另一个线程可以调用非synchronized修饰的方法，互不影响
 */
public class SynchronizedTest {
	 
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
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("methodB-" + i );
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
    }
 
    public static void main(String[] args) {
        final SynchronizedTest test = new SynchronizedTest();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.methodA();
            }
        });
        thread1.start();
 
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.methodB();
            }
        });
        thread2.start();
    }
}
