package org.example.service;

public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("I am adding");
    }

    @Override
    public void delete() {
        System.out.println("I am deleting");
    }
}
