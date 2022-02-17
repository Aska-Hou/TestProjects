package JDK8.map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class MyHashMap {

    private List<Node>[] arr;

    public MyHashMap(int initialSize) {
        this.arr = new List[initialSize];
    }

    public void put(Node targetNode){
        int index = targetNode.hashCode() & (arr.length - 1);
        // hash冲突情况解决
        if (arr[index] != null){
            List<Node> nodeList = arr[index];
            // 遍历list 判断hashcode是否相同
            for (Node node: nodeList){
                // 相同证明为同一个word 次数++
                if (node.getWord().equals(targetNode.getWord())){
                    int originOccurence = node.getOccurence();
                    node.setOccurence(++originOccurence);
                    return;
                }
            }
            // 整个nodeList都不一样证明是hash冲突导致，新加节点即可
            nodeList.add(targetNode);
        }
        // 如果数组中该index下不存在一样的 - 新建list
        else{
            arr[index] = new ArrayList<>();
            arr[index].add(targetNode);
        }
    }

    public int get(Node targetNode){
        int index = targetNode.hashCode() & (arr.length - 1);

        if(arr[index].size() == 0)
            return 0;
        else {
            for (Node node : arr[index]) {
                // 查到了 返回次数
                if (node.getWord().equals(targetNode.getWord()))
                    return node.getOccurence();
            }
            // 查不到 次数为0
            return 0;
        }
    }

    public List<Node> getAll(){
        List<Node> nodeList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++){
            if (arr[i] != null){
                Iterator<Node> iterator = arr[i].iterator();
                while (iterator.hasNext()){
                    nodeList.add(iterator.next());
                }
            }
        }

        return nodeList;
    }
}

class Node implements Comparable{
    private String word;
    private int occurence;

    public Node(String word, int occurence) {
        this.word = word;
        this.occurence = occurence;
    }

    @Override
    public String toString() {
        return "Node{" +
                "word='" + word + '\'' +
                ", occurence=" + occurence +
                '}';
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getOccurence() {
        return occurence;
    }

    public void setOccurence(int occurence) {
        this.occurence = occurence;
    }


    @Override
    public int compareTo(Object o) {
        if (o instanceof Node) {
            Node node = (Node) o;
            // 防止treemap合并K
            if (this.getOccurence() == node.getOccurence())
                return 1;
            return this.getOccurence() - node.getOccurence();
        }
        else return 0;
    }
}
