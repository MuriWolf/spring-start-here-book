package com.example.sq_ch13_ex1.repositories.mappers;

import com.example.sq_ch13_ex1.models.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        var account = new Account();
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setAmount(rs.getBigDecimal("amount"));

        return account;
    }
}
