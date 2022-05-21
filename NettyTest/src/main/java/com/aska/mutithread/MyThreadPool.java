package com.aska.mutithread;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.stream.Stream;

/**
 * @author Aska
 * @description Function Description
 * @create 2022/5/18 18:55
 */
public class MyThreadPool<T extends Runnable> {

    private static final int MAX_THREAD_SIZE = 10;
    private static final int MAX_QUEUE_SIZE = 5;

    private volatile AtomicInteger indexOfTasks = new AtomicInteger(0);

    private LinkedList<T> tasks = new LinkedList<>();

    private List<WorkerThread> workerThreads;

    public MyThreadPool() {
        workerThreads = new ArrayList<>(MAX_THREAD_SIZE);
        initWorkerThreads();
    }

    public MyThreadPool(int initThreadSize){
        int size = Math.min(initThreadSize, MAX_THREAD_SIZE);
        workerThreads = new ArrayList<>(size);
        initWorkerThreads();
    }

    public synchronized void execute(T task){
        if (tasks.size() >= MAX_QUEUE_SIZE) {
            return;
        }

        tasks.addLast(task);
        notifyAll();
    }

    public synchronized void clearTasks(){
        tasks.clear();
    }

    public void initWorkerThreads(){

        for (int i = 1; i <= MAX_THREAD_SIZE; i++){
            workerThreads.add(new WorkerThread(i));
        }

        workerThreads.stream().forEach((workerThread -> {
            Thread thread = new Thread(workerThread, "WorkThread -- " + workerThread.getIndex());
            thread.start();
        }));

    }

    public synchronized void shutDownThreadPool(){
        workerThreads.stream().forEach((workerThread -> {
            workerThread.setRunning(false);
        }));
        notifyAll();
    }

    class WorkerThread implements Runnable{

        private volatile boolean running = true;

        public void setRunning(boolean running) {
            this.running = running;
        }

        private int index;

        public int getIndex() {
            return index;
        }

        public WorkerThread(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            // Thread 什么时候死
            while (true) {
                T task = null;
                // 获取大锁 锁整个threadLocal 即每次只有一个线程可以从threadLocal中拿任务 防止任务重复分配
                synchronized (MyThreadPool.this) {
                    // 把任务分出去给每一个线程 分配过程加锁 线程独有
                    while (tasks.isEmpty()) {
                        // 被shutdown worker直接结束
                        if (!running) {
                            return;
                        }

                        try {
                            MyThreadPool.this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task = tasks.removeFirst();
                }

                if (task != null) {
                    try {
                        task.run();
                    } catch (Exception exception){
                        System.out.println("忽略所有Job运行时产生的异常，防止job异常导致线程池中的worker线程中断");
                    }
                }
            }


        }


    }

}
