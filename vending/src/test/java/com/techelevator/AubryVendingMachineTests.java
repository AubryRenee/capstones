package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class AubryVendingMachineTests {
    private VendingMachine vendingMachineTest = new VendingMachine();

 /*   @Test
    public void purchaseItem_valid_slotNumber_should_return_dispenseMessage() {
        //Arrange
        String testSlot = "B2";
        String expected = "Munch Munch, Yum!";
        BigDecimal currentMoney = BigDecimal.valueOf(5.00);

        //Act
        String actual = vendingMachineTest.purchaseItem(testSlot);

        //Assert
        Assert.assertEquals(expected, actual);
    }
*/
    @Test
    public void purchaseItem_notEnoughMoney_should_return_insufficientFundsMessage() {
        //Arrange
        String testSlot = "B2";
        String expected = "Insufficient funds";
        BigDecimal currentMoney = BigDecimal.valueOf(0.50);


        //Act
        String actual = vendingMachineTest.purchaseItem(testSlot);

        //Assert
        Assert.assertEquals(expected, actual);
    }
}
