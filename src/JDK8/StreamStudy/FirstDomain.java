package JDK8.StreamStudy;

import java.util.Optional;
import java.util.function.Supplier;

public class FirstDomain {

    public FirstDomain() {

    }

    public static FirstDomain firstDomain;

    public static FirstDomain getFirstDomain() {
        synchronized ("lock") {
//            if (firstDomain == null) {
//                firstDomain = createFirstDomain();
//            }
//            return firstDomain;

            return Optional.ofNullable(FirstDomain.firstDomain).orElse(FirstDomain.firstDomain = createFirstDomain());
        }
    }

    public static FirstDomain functionRefer() {
        firstDomain = createFirstDomain();
        return firstDomain;
    }

    public static FirstDomain createFirstDomain() {
        return new FirstDomain();
    }

    public static void main(String[] args) {
        // static method calling
        FirstService firstService2 = new FirstService() {
            @Override
            public void test1(TestEntry testEntry1) {
                tryStaticMethod(testEntry1);
            }
        };
        FirstService firstService1 = (entry) -> tryStaticMethod(entry);
        FirstService firstService3 = FirstDomain::tryStaticMethod;

        // instance method calling
        FirstDomain firstDomain = new FirstDomain();
        FirstService firstService4 = new FirstService() {
            @Override
            public void test1(TestEntry testEntry1) {
                firstDomain.tryInstanceMethod(testEntry1);
            }
        };
        FirstService firstService5 = (entry) -> firstDomain.tryInstanceMethod(entry);
        FirstService firstService6 = firstDomain::tryInstanceMethod;

        // obj method calling
        FirstService firstService7 = new FirstService() {
            @Override
            public void test1(TestEntry testEntry1) {
                testEntry1.testObjInstanceMethod();
            }
        };
        FirstService firstService8 = (testEntry1 -> testEntry1.testObjInstanceMethod());
        FirstService firstService9 = TestEntry::testObjInstanceMethod;

        // type 4: constructor calling
        SecondService secondService1 = new SecondService() {
            @Override
            public FirstDomain getFirstDomain() {
                return new FirstDomain();
            }
        };
        SecondService secondService2 = () -> new FirstDomain();
        SecondService secondService = FirstDomain::new;


    }

    public static void tryStaticMethod(TestEntry entry1) {
        System.out.println("Hello Static Method" + entry1);
    }

    public void tryInstanceMethod(TestEntry entry1) {
        System.out.println("Hello Instance Method");
    }
}
