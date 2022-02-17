package JDK8.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ReflectTest1 implements ReflectTestInterface{

    @Override
    public void sad() {
        System.out.println("I am sad...");
    }

    public static void main(String[] args) {
        // 被代理的对象
        ReflectTest1 reflectTest1 = new ReflectTest1();
        // MyInvocationHandler 即为代理增强方法的规则
        MyInvocationHandler invocationHandler = new MyInvocationHandler(reflectTest1);
        // 有了规则，传入最终返回的接口类型，即可获得此接口的实现类
        ReflectTestInterface reflectTest2 = (ReflectTestInterface) Proxy.newProxyInstance(reflectTest1.getClass().getClassLoader(), reflectTest1.getClass().getInterfaces(), invocationHandler);

        reflectTest2.sad();


    }

    @Override
    public void happy(){
        System.out.println("I am Happy");
    }


}

class MyInvocationHandler implements InvocationHandler{

    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    public Object object;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before Happy...");
        Object result = method.invoke(object, args);
        System.out.println("After Happy...");
        return result;
    }
}