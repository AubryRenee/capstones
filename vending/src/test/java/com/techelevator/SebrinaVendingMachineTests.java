package com.techelevator;

import com.techelevator.item.*;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class SebrinaVendingMachineTests {

//    inventoryTestItems.put("A2", new ChipItem("A2", "Stackers", BigDecimal.valueOf(1.45)));
//    inventoryTestItems.put("B2", new CandyItem("B2", "Cowtales", BigDecimal.valueOf(1.50).setScale(2,RoundingMode.HALF_UP)));
//    inventoryTestItems.put("C2", new DrinkItem("C2", "Dr. Salt", BigDecimal.valueOf(1.50).setScale(2, RoundingMode.HALF_UP)));
//    inventoryTestItems.put("D2", new GumItem("D2", "Little League Chew", BigDecimal.valueOf(0.95)));
//    inventoryTestItems.get("B2").setInventory(2);
private Map<String, Item> itemMap = new TreeMap<>();
    File file = new File("vendingmachine.csv");
//
//            for (Map.Entry<String, Item> entry : itemMap.entrySet()){
//        System.out.println(entry.getValue());
//    }
    String expected = "Stackers|0Cowtales|3Dr. Salt|0Little League Chew|0**TOTAL";





    @Test
    public void feedMoney_slotNumber_returnsCurrMoney(){
        VendingMachine vendingMachine = new VendingMachine();
        BigDecimal data = BigDecimal.valueOf(10);
        BigDecimal expected = BigDecimal.valueOf(10).setScale(2);
        BigDecimal actual = vendingMachine.feedMoney(data).setScale(2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void feedMoney_10_Dollars_returnsCurrMoney(){
        VendingMachine vendingMachine = new VendingMachine();
        BigDecimal data = BigDecimal.valueOf(10);
        BigDecimal expected = BigDecimal.valueOf(10).setScale(2);
        BigDecimal actual = vendingMachine.feedMoney(data).setScale(2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void feedMoney_1_Dollars_returnsCurrMoney(){
        VendingMachine vendingMachine = new VendingMachine();
        BigDecimal data = BigDecimal.valueOf(1);
        BigDecimal expected = BigDecimal.valueOf(1).setScale(2);
        BigDecimal actual = vendingMachine.feedMoney(data).setScale(2);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void feedMoney_5_Dollars_returnsCurrMoney(){
        VendingMachine vendingMachine = new VendingMachine();
        BigDecimal data = BigDecimal.valueOf(5);
        BigDecimal expected = BigDecimal.valueOf(5).setScale(2);
        BigDecimal actual = vendingMachine.feedMoney(data).setScale(2);
        Assert.assertEquals(expected, actual);
    }


    @Test
    @Ignore
    public void displayItems_zeroBalance_returnsCorrectString(){
        //Arrange
        itemMap.put("A2", new ChipItem("A2", "Stackers", BigDecimal.valueOf(1.45)));

        int invQty = itemMap.get("A2").getInventory();
        VendingMachine vendingMachine = new VendingMachine();

        String expected = "A2|Stackers|1.45|5";
        String actual = String.valueOf(vendingMachine.displayItems());

        //Act


        //Assert
        Assert.assertEquals(expected, actual);
    }
}
