package com.aska.mutithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Aska
 * @description Function Description
 * @create 2022/5/20 15:13
 */
public class ReetrantLockVisilTest {

    public static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        SharedClass sharedClass = new SharedClass();
        IndividualClass individualClass = new IndividualClass();

        Job job = new Job(sharedClass,individualClass);

        Thread thread1 = new Thread(job);
        thread1.start();
        Thread.sleep(200);
        sharedClass.changeFlag();


    }

}

class SharedClass {

    private boolean flag = true;
    private boolean testFlag = true;
//    public volatile boolean temp = true;

    public Lock lock = new ReentrantLock();

    public Integer i = 1;

    public void changeFlag() {
        flag = false;
        testFlag = false;
        System.out.println("CHANGE!!!");
    }

    public boolean isFlag() {
        boolean result = flag;
        return result;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isTestFlag() {
        return testFlag;
    }

    public void setTestFlag(boolean testFlag) {
        this.testFlag = testFlag;
    }
}


class Job implements Runnable {

    public SharedClass sharedClass;

    public IndividualClass individualClass;

    public Integer i;

    public Job(SharedClass sharedClass, IndividualClass individualClass) {
        this.sharedClass = sharedClass;
        this.individualClass = individualClass;
        i = sharedClass.i;
    }

    @Override
    public void run() {
        while (sharedClass.isFlag() || sharedClass.isTestFlag()) {
            // 对volatile共享变量读，主内存共享变量会同步到该线程缓存中，即flag和testFlag更新
            boolean result = individualClass.temp;
        }


        System.out.println("STOP");
    }


}
