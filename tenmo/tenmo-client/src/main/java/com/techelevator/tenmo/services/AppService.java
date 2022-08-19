package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import com.techelevator.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.sql.ClientInfoStatus;
import java.sql.SQLOutput;

public class AppService {

    private final String baseUrl;
    private final RestTemplate restTemplate = new RestTemplate();

    public AppService(String url) { this.baseUrl = url; }

    public BigDecimal getBalance (AuthenticatedUser authenticatedUser) {
        BigDecimal balance = null;
        try {
            ResponseEntity<BigDecimal> response = restTemplate.exchange(baseUrl + "user/" + authenticatedUser.getUser().getId() + "/balance",
                    HttpMethod.GET, getEntity(authenticatedUser.getToken()), BigDecimal.class);
            balance = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return balance;
    }


    public void viewTransferHistory(AuthenticatedUser authenticatedUser) {
        // TODO Auto-generated method stub
//        for(Transfer transfer : transfers) {
//            System.out.println(transfer.getId() + "      " + transfer.(if accountTo, then "From:", if accountFrom, then "To:") +
//                    transfer.getUsername()other account + amount transfered);
//        }


    }

    public Transfer viewTransferDetails(int transferId, AuthenticatedUser authenticatedUser) {
       Transfer transfer = new Transfer();
//        try {
//            ResponseEntity<Transfer> transfer  = restTemplate.exchange(baseUrl + transferId + "/transferdetails", HttpMethod.GET, getEntity(authenticatedUser.getToken()), Transfer.class)
//        } catch (RestClientResponseException | ResourceAccessException e) {
//            BasicLogger.log(e.getMessage());
//        }
        return transfer;
    }

    public Transfer sendTransfer(BigDecimal transferAmount, int otherUserId, AuthenticatedUser currentUser) {
        Transfer transfer = new Transfer();
        try {
            transfer.setTransferAmount(transferAmount);
            transfer.setTransferTypeId(2);
            transfer.setTransferStatusId(2);

            ResponseEntity<Integer> accountFrom = restTemplate.exchange(baseUrl + "user/" + currentUser.getUser().getId() + "/account", HttpMethod.GET,
                    getEntity(currentUser.getToken()),Integer.class);
            transfer.setAccountFrom(accountFrom.getBody());

            ResponseEntity<Integer> accountTo = restTemplate.exchange(baseUrl + "user/" + otherUserId + "/account", HttpMethod.GET,
                    getEntity(currentUser.getToken()), Integer.class);
            transfer.setAccountTo(accountTo.getBody());

        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return transfer;
    }

    public User[] getOtherUsers(AuthenticatedUser authenticatedUser) {
        User[] users = null;
        ResponseEntity<User[]> response = restTemplate.exchange(baseUrl + "users/" + authenticatedUser.getUser().getId(), HttpMethod.GET,
                getEntity(authenticatedUser.getToken()), User[].class);
        users = response.getBody();
        return users;
        // Make print method in console service for below to print array of users
        //for(User user : users) {
          //  System.out.println(user.getId() + "               " + user.getUsername());
       // }
    }

    public BigDecimal transferFunds (Transfer transfer, AuthenticatedUser sender) {
        BigDecimal senderBalance = getBalance(sender);

        if (transfer.getTransferAmount().compareTo(senderBalance) <= 0) {
            try {
                restTemplate.exchange(baseUrl + "transfers/", HttpMethod.POST, transferEntity(sender.getToken(), transfer), Transfer.class);
                System.out.println("");
            } catch
                (RestClientResponseException | ResourceAccessException e) {
                    BasicLogger.log(e.getMessage());
            }
        }
        return getBalance(sender);
    }

    public String getUsernameByAccountId (int accountId, AuthenticatedUser authenticatedUser) {
        String username = "";
        try {
            ResponseEntity<String> response = restTemplate.exchange(baseUrl + accountId + "/username",
                    HttpMethod.GET, getEntity(authenticatedUser.getToken()), String.class);
            username = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return username;
    }

    private HttpEntity<Void> getEntity (String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        return new HttpEntity<>(headers);
    }

    private HttpEntity<Transfer> transferEntity (String token, Transfer transfer) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(transfer, headers);
    }

}
