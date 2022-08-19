package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.math.BigDecimal;

public interface TransferDao {

    void sendBucks(Transfer transfer);

    void insertTransfer(Transfer transfer);

    Transfer transferDetails (int transferId);

}
