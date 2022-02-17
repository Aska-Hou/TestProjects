package JDK8.Lambda;

import java.util.ArrayList;
import java.util.function.Consumer;

public class InterfaceClassImpl{

    public static void main(String[] args) {
        int result = ((InterfaceClass) (a, b) -> {
            return a + b;
        }).test1(1, 2);
        System.out.println(result);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hello");
        arrayList.add("World");
        arrayList.forEach((Consumer<? super String>) (string)->{
            System.out.println("The String is " + string);
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " Current Thread...");
            }
        }).start();

        new Thread(()-> System.out.println("Lambda " + Thread.currentThread() + " Current Thread..."));
        
    }

}
