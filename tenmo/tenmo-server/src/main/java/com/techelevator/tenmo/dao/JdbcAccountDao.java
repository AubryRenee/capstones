package com.techelevator.tenmo.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class JdbcAccountDao implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public BigDecimal getBalanceByUserId(int userId) {
        String sql = "SELECT balance FROM account WHERE user_id = ?";
        try {
            BigDecimal balance = jdbcTemplate.queryForObject(sql, BigDecimal.class, userId);
            return balance;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    public int getAccountByUserId(int userId) {
        String sql = "SELECT account_id FROM account WHERE user_id = ?";
        try {
            int accountId = jdbcTemplate.queryForObject(sql, Integer.class, userId);
            return accountId;
        } catch (EmptyResultDataAccessException | NullPointerException ex) {
            return 0;
        }
    }

    public String getUsernameByAccountId(int accountId) {
        String sql = "SELECT username FROM tenmo_user " +
                "JOIN account ON account.user_id = tenmo_user.user_id" +
                "WHERE account_id = ?";
        try {
            String username = jdbcTemplate.queryForObject(sql, String.class, accountId);
            return username;
        } catch (EmptyResultDataAccessException | NullPointerException ex) {
            return null;
        }
    }


}
