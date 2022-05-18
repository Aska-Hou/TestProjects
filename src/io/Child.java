package io;

import java.io.Serializable;

public class Child implements Serializable {

    public static final long serialVersionUID = 1L;

    String name;

    Child child;

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", child=" + child +
                '}';
    }
}
