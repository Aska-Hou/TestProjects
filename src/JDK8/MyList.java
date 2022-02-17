package JDK8;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class MyList {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//
//        /*
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//        */
//
//        list.forEach(integer -> System.out.println(integer));
//
////        list.forEach(System.out::println);
//
//        list.forEach((integer -> {
//            System.out.println(integer);
//            System.out.println(integer);
//        }));


        PriorityQueue<User> priorityQueue = new PriorityQueue<>();

        User user1 = new User(7, "user1");
        User user2 = new User(3, "user2");
        User user3 = new User(4, "user3");
        User user4 = new User(2, "user4");

        priorityQueue.add(user1);
        priorityQueue.add(user2);
        priorityQueue.add(user3);
        priorityQueue.add(user4);

        for (int i = 0; i < 4; i++){
            System.out.println(priorityQueue.poll());
        }


    }

}

class User implements Comparable{
    private int id;
    private String name;



    public User(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        int id1 = this.getId();
        User o1 = (User) o;
        int id2 = o1.getId();
        return id1 - id2;
    }
}

class MyConsumer implements Consumer{

    @Override
    public void accept(Object o) {

    }
}
