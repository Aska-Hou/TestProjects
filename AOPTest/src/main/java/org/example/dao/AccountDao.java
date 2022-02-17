package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
public interface AccountDao {

    @Update("update account set money = money - #{money} where id = #{id}")
    public int decreaseAccountMoney(@Param("id") int accountId, @Param("money") double money);

    @Update("update account set money = money + #{money} where id = #{id}")
    public int increaseAccountMoney(@Param("id") int accountId, @Param("money") double money);
}