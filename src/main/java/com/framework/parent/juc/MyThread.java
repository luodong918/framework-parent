package com.framework.parent.juc;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author luodong
 * @date 2022/4/21
 */
public class MyThread {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.toTicket();
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.toTicket();
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.toTicket();
                }
            }
        },"C").start();


//        new ReentrantLock()

    }
}

class Ticket {
    private int number = 30;

    public void toTicket() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出第" + number + "张票，还剩" + (number--) + "张票");
        }
    }
}