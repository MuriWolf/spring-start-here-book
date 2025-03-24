package com.example.sq_ch12_ex2.repositories;

import com.example.sq_ch12_ex2.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {

    private final JdbcTemplate jdbcTemplate;

    public PurchaseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void storePurchase(Purchase purchase) {
        String sql = "INSERT INTO purchase (product, price) VALUES(?, ?)";

        jdbcTemplate.update(sql, purchase.getProduct(), purchase.getPrice());
    }

    public List<Purchase> getAllPurchases() {
       String sql = "SELECT * FROM purchase";

        RowMapper<Purchase> purchaseRowMapper = (r, n) -> {
           var row = new Purchase();
           row.setId(r.getInt("id"));
           row.setProduct(r.getString("product"));
           row.setPrice(r.getBigDecimal("price"));

           return row;
        };

        return jdbcTemplate.query(sql, purchaseRowMapper);
    }
}
