package org.example;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface MyAnno {

    public String name();

    public int age() default 20;

}
