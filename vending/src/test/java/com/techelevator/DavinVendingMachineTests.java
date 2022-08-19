package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class DavinVendingMachineTests {
    private VendingMachine vendingMachine;

    @Test
    public void returnChange_happyCase_returnsCorrectString(){
        //Arrange
        vendingMachine = new VendingMachine(BigDecimal.valueOf(1.65));
        String expected = "Your Change is $1.65 \n" +
                "Dispensing 6 quarters 1 dimes 1 nickels.";
        String actual = "";

        //Act
        actual = vendingMachine.returnChange();

        //Assert
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void returnChange_zeroBalance_returnsCorrectString(){
        //Arrange
        vendingMachine = new VendingMachine(BigDecimal.valueOf(0.00));
        String expected = "Your Change is $0.00 \n" +
                "Dispensing 0 quarters 0 dimes 0 nickels.";
        String actual = "";

        //Act
        actual = vendingMachine.returnChange();

        //Assert
        Assert.assertEquals(expected, actual);
    }
}
