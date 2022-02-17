package JDK8.map;

import jdk.nashorn.api.tree.Tree;

import java.util.*;
import java.util.function.BiConsumer;

public class TestMyHashMap {

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap(6);
        Node node1 = new Node("Word1", 1);
        Node node2 = new Node("Word2", 1);
        Node node3 = new Node("Word3", 1);
        Node node4 = new Node("Word4", 1);
        Node node5 = new Node("Word5", 1);
        Node node6 = new Node("Word9999", 1);

        myHashMap.put(node1);
        myHashMap.put(node2);
        myHashMap.put(node3);
        myHashMap.put(node4);
        myHashMap.put(node5);

        myHashMap.put(node2);
        myHashMap.put(node2);

        myHashMap.put(node5);



//        System.out.println("Number of node1: " + myHashMap.get(node1));
//        System.out.println("Number of node2: " + myHashMap.get(node2));
//        System.out.println("Number of node3: " + myHashMap.get(node3));
//        System.out.println("Number of node4: " + myHashMap.get(node4));
//        System.out.println("Number of node5: " + myHashMap.get(node5));
//        System.out.println("Number of node6: " + myHashMap.get(node6));

        /*
        // priority Queue实现
        PriorityQueue<Node> queue = new PriorityQueue<>();

        for (Node node : myHashMap.getAll()) {
            queue.add(node);
        }

        queue.forEach(System.out::println);

        for (int i = 0; i < 5; i++){
            System.out.println("I am polled" + queue.poll());
        }
         */


        Map<Node, String> map = new TreeMap<>();
        for (Node node : myHashMap.getAll()) {
            map.put(node, node.getWord());
        }
        map.forEach((occurence, word) -> {
            System.out.println(word + " : " + occurence);
        });

        List list = new ArrayList<>();


//        queue.forEach(System.out::println);

//        System.out.println(myHashMap.getAll());
//        HeapSortDemo.HeapSort(myHashMap.getAll().toArray(new Node[0]));
    }
}
