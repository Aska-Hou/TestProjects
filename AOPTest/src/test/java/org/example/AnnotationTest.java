package org.example;

import org.example.service.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"}) //加载配置文件
public class AnnotationTest {

    @Autowired
    public MyService myService;

    @Test
    @MyAnno(name = "aska")
    public void test(){
        myService.service1();
    }

    @MyAnno(name = "aska")
    public static void service1(){
        System.out.println("Hello World...");
    }
}
