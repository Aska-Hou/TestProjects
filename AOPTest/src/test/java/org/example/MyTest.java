package org.example;

import org.example.pojo.Account;
import org.example.service.TransferMoneyService;
import org.example.service.UserService;
import org.example.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"}) //加载配置文件
public class MyTest {

    @Autowired
    public UserService userService;

    @Autowired
    public TransferMoneyService transferMoneyService;

    @Autowired
    public TransactionTemplate transactionTemplate;

    @Test
    public void test(){
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserService userService = classPathXmlApplicationContext.getBean("userService", UserService.class);

        userService.add();
    }

    @Test
    public void testTransfer() throws Exception {
        transferMoneyService.transferMoney(new Account(1, "Aska", 10), new Account(2, "Cath", 10), 10);
    }

    @Test
    public void programmingTransactionTest(){
        transactionTemplate.execute((status) -> {
            status.isRollbackOnly();
            return null;
        });



    }
}
