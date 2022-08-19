package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class JdbcTransferDao implements TransferDao{

    private JdbcTemplate jdbcTemplate;
    public JdbcTransferDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate; }

    public void sendBucks (Transfer transfer) {
        String sqlGet = "UPDATE account SET balance = balance + ? WHERE account_id = ?";
        String sqlSend = "UPDATE account SET balance = balance - ? WHERE account_id = ?";
        try {
            jdbcTemplate.update(sqlGet, transfer.getTransferAmount(), transfer.getAccountTo());
            jdbcTemplate.update(sqlSend, transfer.getTransferAmount(), transfer.getAccountFrom());

        } catch (EmptyResultDataAccessException ex) {
        }
    }

    public void insertTransfer (Transfer transfer) {
        String sqlPost = "INSERT INTO transfer VALUES (DEFAULT, ?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sqlPost,transfer.getTransferTypeId(), transfer.getTransferStatusId(),
                    transfer.getAccountFrom(), transfer.getAccountTo(), transfer.getTransferAmount());
        } catch (EmptyResultDataAccessException ex) {

        }
    }


    public Transfer transferDetails (int transferId) {
        Transfer transfer = new Transfer();
        String sql = "SELECT * FROM transfer WHERE transfer_id = ?";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, String.class, transferId);
            transfer.setAccountFrom(rowSet.getInt("account_from"));
            transfer.setAccountTo(rowSet.getInt("account_to"));
            transfer.setTransferAmount(rowSet.getBigDecimal("amount"));
            transfer.setTransferId(transferId);
        } catch (EmptyResultDataAccessException ex) {
        }
        return transfer;
    }

    public void viewAllTransfers (User user, Account account) {
        String sqlViewTransfer = "SELECT transfer_id, username, amount, account_from, account_to FROM tenmo_user\n" +
                "JOIN account ON account.user_id = tenmo_user.user_id\n" +
                "JOIN transfer ON transfer.account_to = account.account_id OR transfer.account_from = account.account_id\n" +
                "JOIN transfer_type ON transfer_type.transfer_type_id = transfer.transfer_type_id\n" +
                "WHERE (account_from = ? OR account_to = ?) AND username != '?'";
        try {
            jdbcTemplate.queryForRowSet(sqlViewTransfer,account.getAccountId(), account.getAccountId(), user.getUsername());
        } catch (EmptyResultDataAccessException ex) {

        }
    }

}
