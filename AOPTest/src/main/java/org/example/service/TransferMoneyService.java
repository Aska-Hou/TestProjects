package org.example.service;


import org.example.pojo.Account;

public interface TransferMoneyService {

    // Modified dev
    public boolean transferMoney(Account fromAccount, Account targetAccount, double money) throws Exception;
}
