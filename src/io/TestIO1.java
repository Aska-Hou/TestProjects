package io;

import java.io.*;

public class TestIO1 {

    public static void main(String[] args) throws Exception {
        File file = new File("test.txt");

//        FileOutputStream outputStream1 = new FileOutputStream(file);
//        ObjectOutputStream outputStream2 = new ObjectOutputStream(outputStream1);
//        Child child = new Child();
//        child.age = 1;
//        child.name = "Aska";
//        outputStream2.writeObject(child);
//        outputStream2.close();

        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object child1 = objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(child1);
    }
}

