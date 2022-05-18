package com.aska.mutithread;

/**
 * @author Aska
 * @description Function Description
 * @create 2022/5/17 23:20
 */
public class TestMultiThread {

    public static final String lock = "lock";

    public static void main(String[] args) throws InterruptedException {
        Thread jobThread1 = new Thread(new WaitJob(lock), "Wait Job Thread");
        Thread jobThread2 = new Thread(new ExecJob(lock), "Exec Job Thread");
        jobThread1.start();
        jobThread2.start();


        jobThread1.join();

        System.out.println("Last Line");



    }
}

class ExecJob implements Runnable{
    private String lock;
    private String testLock = "test";

    public ExecJob(String lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            for (int i = 0; i < 10; i++){
                System.out.println(Thread.currentThread() + " Executing...");
                try {
                    testLock.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class WaitJob implements Runnable{

    private String lock;

    public WaitJob(String lock) {
        this.lock = lock;
    }

    public String getLock() {
        return lock;
    }

    public void setLock(String lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread() + " Waiting...");
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
