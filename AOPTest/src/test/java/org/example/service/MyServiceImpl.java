package org.example.service;

import org.example.MyAnno;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService{
    @Override
    @MyAnno(name = "Cath HK")
    public void service1() {
        System.out.println("Hello world");
    }

}
