package JDK8.StreamStudy;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {

    public static void main(String[] args) {
        ArrayList<TestEntry> arrayList = new ArrayList<>();
        arrayList.add(new TestEntry(1, "I am one"));
        arrayList.add(new TestEntry(2, "I am two"));
        arrayList.add(new TestEntry(3, "I am three"));
        arrayList.add(new TestEntry(4, "I am four"));
        arrayList.add(new TestEntry(5, "condition"));

//        Map<Integer, String> map = arrayList.stream().collect(Collectors.toMap(testEntry -> testEntry.getProperty1(), testEntry -> testEntry.getProperty2()));

//        map.forEach((integer, s) -> System.out.println(integer + ", " + s));

        Optional<TestEntry> sum = arrayList.stream().reduce(new BinaryOperator<TestEntry>() {
            @Override
            public TestEntry apply(TestEntry testEntry1, TestEntry testEntry2) {
                return new TestEntry(testEntry1.getProperty1() + testEntry2.getProperty1(), "sum");
            }
        });

        Optional<TestEntry> max = arrayList.stream().max((o1, o2) -> o1.getProperty1() - o2.getProperty1());
//        System.out.println(max.get());

        boolean result = arrayList.stream().noneMatch((testEntry) -> testEntry.getProperty2().equals("condition"));
        System.out.println(result);

//        System.out.println(sum.get().property1);

        Stream<TestEntry> hello = arrayList.stream().filter(testEntry -> testEntry.getProperty1() > 5 && testEntry.getProperty2().equals("Hello"));
        List<TestEntry> newList = hello.collect(Collectors.toList());

        Stream<TestEntry> limit = arrayList.stream().skip(1).limit(2);

        arrayList.stream().sorted((o1, o2) -> o1.getProperty1() - o2.getProperty1()).forEach((testEntry -> System.out.println(testEntry)));

        arrayList.stream().filter((testEntry -> testEntry.getProperty2().equals("mayikt")))
                .sorted((o1, o2) -> o2.getProperty1() - o1.getProperty1()).limit(2)
                .forEach(testEntry -> System.out.println(testEntry));

    }
}

