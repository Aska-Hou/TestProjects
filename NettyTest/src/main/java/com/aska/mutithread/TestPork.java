package com.aska.mutithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Aska
 * @description Function Description
 * @create 2022/5/19 16:56
 */
public class TestPork {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyParkThread());
        thread.start();
        Thread.sleep(2000);
        System.out.println(thread.getState());
        LockSupport.unpark(thread);
        thread.interrupt();
    }
}

class MyParkThread implements Runnable{

    @Override
    public void run() {
        System.out.println("Start...");
        LockSupport.park(this);
        System.out.println("End...");
    }
}
