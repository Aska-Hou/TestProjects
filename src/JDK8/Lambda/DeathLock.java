package JDK8.Lambda;

public class DeathLock {
    public static void main(String[] args) {
        InnerLock innerLock1 = new InnerLock();
        InnerLock innerLock2 = new InnerLock();
        new Thread(()->{
            try {
                lock(innerLock1, innerLock2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                lock(innerLock2, innerLock1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void lock(InnerLock innerLock1, InnerLock innerLock2) throws InterruptedException {
        synchronized (innerLock1){
            System.out.println(Thread.currentThread() + "I will sleep1.");
            Thread.sleep(1000);
            synchronized (innerLock2){
                System.out.println(Thread.currentThread() + "I will sleep2.");
            }
        }
    }


}

class InnerLock{
    public InnerLock() {
    }
}