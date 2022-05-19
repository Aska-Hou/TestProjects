package com.aska.mutithread;

/**
 * @author Aska
 * @description Function Description
 * @create 2022/5/18 22:15
 */
public class TestMyThreadPool {

    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool();
        myThreadPool.execute(new Task1());
        myThreadPool.execute(new Task2());

        myThreadPool.shutDownThreadPool();

    }


}

class Task1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            System.out.println("Hi Task1...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Task2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            System.out.println("Hi Task2...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}