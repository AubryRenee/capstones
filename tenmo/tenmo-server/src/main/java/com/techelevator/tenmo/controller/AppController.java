package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
public class AppController {
    private AccountDao accountDao;
    private UserDao userDao;
    private TransferDao transferDao;
    public AppController(AccountDao accountDao, UserDao userDao, TransferDao transferDao) {
        this.accountDao = accountDao;
        this.userDao = userDao;
        this.transferDao = transferDao;
    }



    // Get Balance Method
    @RequestMapping(value = "/user/{id}/balance", method = RequestMethod.GET)
    public BigDecimal balance(@PathVariable int id) {
        return accountDao.getBalanceByUserId(id);
    }

    @RequestMapping(value = "/user/{id}/account", method = RequestMethod.GET)
    public int account(@PathVariable int id) {
        return accountDao.getAccountByUserId(id);
    }

    @RequestMapping(value = "/{accountId}/username/", method = RequestMethod.GET)
    public String username(@PathVariable int accountId) {
        return accountDao.getUsernameByAccountId(accountId);
    }

    // Transfer Method
    @RequestMapping(value = "/transfers", method = RequestMethod.POST)
    public void send(@RequestBody Transfer send) {
        transferDao.sendBucks(send);
        transferDao.insertTransfer(send);
        }

    // User List
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public List<User> userList (@PathVariable int id) {return userDao.listOtherUsers(id); }

    // View Transfer by User Table


    // View Transfer Details
    @RequestMapping(value = "{tranferID}/transferdetails", method = RequestMethod.GET)
    public Transfer transfer (@PathVariable int transferId) {
        return transferDao.transferDetails(transferId);
    }




}
