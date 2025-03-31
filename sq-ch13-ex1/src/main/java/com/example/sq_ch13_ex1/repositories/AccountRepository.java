package com.example.sq_ch13_ex1.repositories;

import com.example.sq_ch13_ex1.models.Account;
import com.example.sq_ch13_ex1.repositories.mappers.AccountRowMapper;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    @Query("SELECT * FROM account where name = :name")
    List<Account> findAccountByName(String name);

    @Modifying
    @Query("UPDATE account SET amount = :amount where id = :id")
    void changeAmount(long id, BigDecimal amount);
}