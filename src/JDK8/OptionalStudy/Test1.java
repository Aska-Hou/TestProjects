package JDK8.OptionalStudy;

import JDK8.StreamStudy.FirstDomain;
import JDK8.StreamStudy.TestEntry;

import javax.swing.text.html.Option;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Supplier;

public class Test1 {

    public static void main(String[] args) {
        String var1 = "Hi";
//        TestEntry testEntry1 = new TestEntry();
//        testEntry1.setProperty1(100);
////        testEntry1.setProperty2("hello");
//        String result = Optional.ofNullable(testEntry1)
//                .map(TestEntry::getProperty2).map(String::toUpperCase).orElseGet(()->{
//                    testEntry1.setProperty2("I am Null");
//                    return testEntry1.getProperty2();
//                });
//
//        System.out.println(result);



//        boolean present = Optional.ofNullable(var1).isPresent();//不报错
//        System.out.println(present);
        String result = Optional.ofNullable(var1).orElse("Helllo world");
        Optional.ofNullable(var1).orElse(var1 = "Hello world");
        Optional.ofNullable(var1).orElseGet(() -> "Hello world");

        System.out.println(var1);
//
//        Optional.ofNullable(var1).filter(str->str.equalsIgnoreCase("hello world"));
//        Optional.ofNullable(var1).filter(Test1::testEqual);

//        FirstDomain firstDomain = FirstDomain.getFirstDomain();
//        System.out.println(firstDomain);
//        System.out.println(FirstDomain.firstDomain);




    }

    public static boolean testEqual(String str){
        return str.equalsIgnoreCase("hello world");
    }


}
