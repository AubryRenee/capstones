package com.techelevator.tenmo.dao;

import java.math.BigDecimal;

public interface AccountDao {

   int getAccountByUserId(int id);

    BigDecimal getBalanceByUserId(int id);

    String getUsernameByAccountId(int accountId);

   // getBalanceByAccountId(int id);

   // getUserByAccountId(int id);

}
