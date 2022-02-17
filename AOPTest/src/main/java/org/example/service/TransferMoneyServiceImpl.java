package org.example.service;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSession;
import org.example.dao.AccountDao;
import org.example.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class TransferMoneyServiceImpl implements TransferMoneyService {

    @Autowired
    public AccountDao accountDao;

//    @Autowired
    public TransactionTemplate transactionTemplate;

    public TransferMoneyServiceImpl(PlatformTransactionManager transactionManager) {
        this.transactionTemplate = new TransactionTemplate(transactionManager);
        System.out.println(transactionManager);
    }

    @Override
//    @Transactional(rollbackFor = Exception.class)
    public boolean transferMoney(Account fromAccount, Account targetAccount, double money) throws Exception {
        Boolean transactionResult = transactionTemplate.execute(new TransactionCallback<Boolean>() {
            @Override
            public Boolean doInTransaction(TransactionStatus status) {
                try {
                    increaseMoney(targetAccount, money);
                    int i = 1 / 0;
                    decreaseMoney(fromAccount, money);
                    return true;
                }
                catch (Exception ex){
                    status.setRollbackOnly();
                    System.out.println("[LOG] Error Transaction Rollback...");
                    return false;
                }
            }
        });

        System.out.println("After Transactional...");
        return transactionResult;
    }

    public boolean increaseMoney(Account account, double money) {
        return accountDao.increaseAccountMoney(account.getId(), money) == 1;
    }

    public boolean decreaseMoney(Account account, double money) {
        return accountDao.decreaseAccountMoney(account.getId(), money) == 1;
    }

    @Bean
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }
}
