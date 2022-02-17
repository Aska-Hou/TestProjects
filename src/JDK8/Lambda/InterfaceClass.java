package JDK8.Lambda;

@FunctionalInterface
public interface InterfaceClass {

    public int test1(int a, int b);

    public String toString();

    default void defaultMethod(){
        System.out.println("I am default");
    }

    public static void staticMethod(){
        System.out.println("I am static");
    }
}
