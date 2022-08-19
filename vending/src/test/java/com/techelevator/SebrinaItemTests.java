package com.techelevator;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.techelevator.item.*;
import org.mockito.internal.matchers.Null;

import java.math.BigDecimal;

public class SebrinaItemTests {
    GumItem actualGum = new GumItem("D3", "Chiclets", BigDecimal.valueOf(0.75));
    CandyItem actualCandy = new CandyItem("B1", "Moonpie", BigDecimal.valueOf(1.80));
    ChipItem actualChip =  new ChipItem("D2", "Potato Crisps", BigDecimal.valueOf(3.05));
    DrinkItem actualDrink = new DrinkItem("A1", "Cola", BigDecimal.valueOf(0.95));

    String expected;
    Item item;




    @Test
    public void toString_Gum_Inventory_Equals_Zero_returnsStringSOLDOUT(){
        //Arrange
        String expected;
        actualGum.setInventory(0);
        System.out.println(actualGum.getInventory());

        if(actualGum.getInventory() != 0) {
            expected = (actualGum.getSlot() + "|" + actualGum.getName() + "|" + actualGum.getPrice() + "|" + actualGum.getInventory());
        }
        else {
            expected = (actualGum.getSlot() + "|" + actualGum.getName() + "|" + actualGum.getPrice() + "|SOLD OUT").toString();
        }
        System.out.println(expected);
        //Act
        String actual = actualGum.toString();

        //Assert
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void toString_Gum_Inventory_notEqual_Zero_returnsString(){
        //Arrange
        String expected;
        actualGum.setInventory(4);
        System.out.println(actualGum.getInventory());

        if(actualGum.getInventory() != 0) {
            expected = (actualGum.getSlot() + "|" + actualGum.getName() + "|" + actualGum.getPrice() + "|" + actualGum.getInventory());
        }
        else {
            expected = (actualGum.getSlot() + "|" + actualGum.getName() + "|" + actualGum.getPrice() + "|SOLD OUT").toString();
        }
        System.out.println(expected);
        //Act
        String actual = actualGum.toString();

        //Assert
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void toString_Gum_Inventory_IsNull_returnsString(){
        //Arrange
        String expected;
       try{
//            nullValue = null;
           actualGum.setInventory(4);
       }catch(NullPointerException e){
            e.getMessage();
        }
        System.out.println(actualGum.getInventory());

        if(actualGum.getInventory() != 0) {
            expected = (actualGum.getSlot() + "|" + actualGum.getName() + "|" + actualGum.getPrice() + "|" + actualGum.getInventory());
        }
        else {
            expected = (actualGum.getSlot() + "|" + actualGum.getName() + "|" + actualGum.getPrice() + "|SOLD OUT").toString();
        }
        System.out.println(expected);
        //Act
        String actual = actualGum.toString();

        //Assert
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void toString_Candy_Inventory_notEqual_Zero_returnsString(){
        //Arrange
        String expected;
        actualCandy.setInventory(4);
        System.out.println(actualCandy.getInventory());

        if(actualCandy.getInventory() != 0) {
            expected = (actualCandy.getSlot() + "|" + actualCandy.getName() + "|" + actualCandy.getPrice() + "|" + actualCandy.getInventory());
        }
        else {
            expected = (actualCandy.getSlot() + "|" + actualCandy.getName() + "|" + actualCandy.getPrice() + "|SOLD OUT").toString();
        }
        System.out.println(expected);
        //Act
        String actual = actualCandy.toString();

        //Assert
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void toString_Candy_Inventory_Equals_Zero_returnsStringSOLDOUT(){
        //Arrange
        String expected;
        actualCandy.setInventory(0);
        System.out.println(actualCandy.getInventory());

        if(actualCandy.getInventory() != 0) {
            expected = (actualCandy.getSlot() + "|" + actualCandy.getName() + "|" + actualCandy.getPrice() + "|" + actualCandy.getInventory());
        }
        else {
            expected = (actualCandy.getSlot() + "|" + actualCandy.getName() + "|" + actualCandy.getPrice() + "|SOLD OUT").toString();
        }
        System.out.println(expected);
        //Act
        String actual = actualCandy.toString();

        //Assert
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void toString_Chip_Inventory_notEqual_Zero_returnsString(){
        //Arrange
        String expected;
        actualChip.setInventory(4);
        System.out.println(actualChip.getInventory());

        if(actualChip.getInventory() != 0) {
            expected = (actualChip.getSlot() + "|" + actualChip.getName() + "|" + actualChip.getPrice() + "|" + actualChip.getInventory());
        }
        else {
            expected = (actualChip.getSlot() + "|" + actualChip.getName() + "|" + actualChip.getPrice() + "|SOLD OUT").toString();
        }
        System.out.println(expected);
        //Act
        String actual = actualChip.toString();

        //Assert
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void toString_Chip_Inventory_Equals_Zero_returnsStringSOLDOUT(){
        //Arrange
        String expected;
        actualChip.setInventory(0);
        System.out.println(actualChip.getInventory());

        if(actualChip.getInventory() != 0) {
            expected = (actualChip.getSlot() + "|" + actualChip.getName() + "|" + actualChip.getPrice() + "|" + actualChip.getInventory());
        }
        else {
            expected = (actualChip.getSlot() + "|" + actualChip.getName() + "|" + actualChip.getPrice() + "|SOLD OUT").toString();
        }
        System.out.println(expected);
        //Act
        String actual = actualChip.toString();

        //Assert
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void toString_Drink_Inventory_notEqual_Zero_returnsString(){
        //Arrange
        String expected;
        actualDrink.setInventory(4);
        System.out.println(actualDrink.getInventory());

        if(actualDrink.getInventory() != 0) {
            expected = (actualDrink.getSlot() + "|" + actualDrink.getName() + "|" + actualDrink.getPrice() + "|" + actualDrink.getInventory());
        }
        else {
            expected = (actualDrink.getSlot() + "|" + actualDrink.getName() + "|" + actualDrink.getPrice() + "|SOLD OUT").toString();
        }
        System.out.println(expected);
        //Act
        String actual = actualDrink.toString();

        //Assert
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void toString_Drink_Inventory_Equals_Zero_returnsStringSOLDOUT(){
        //Arrange
        String expected;
        actualDrink.setInventory(0);
        System.out.println(actualDrink.getInventory());

        if(actualDrink.getInventory() != 0) {
            expected = (actualDrink.getSlot() + "|" + actualDrink.getName() + "|" + actualDrink.getPrice() + "|" + actualDrink.getInventory());
        }
        else {
            expected = (actualDrink.getSlot() + "|" + actualDrink.getName() + "|" + actualDrink.getPrice() + "|SOLD OUT").toString();
        }
        System.out.println(expected);
        //Act
        String actual = actualDrink.toString();

        //Assert
        Assert.assertEquals(expected.toString(), actual.toString());
    }


    @Test
    public void dispenseMessage_GUM_returnsChew(){
        GumItem gum = new GumItem("D3", "Chiclets", BigDecimal.valueOf(0.75));
        String data;
        if(gum.equals(true)){
           data = "Chew Chew, Yum!";
        }
        String expected = "Chew Chew, Yum!";
        String actual = gum.dispenseMessage();

        //Assert
        Assert.assertEquals(expected.toString(), actual.toString());
    }
    @Test
    public void dispenseMessage_DRINK_returnsGlug(){
        DrinkItem drink = new DrinkItem("A1", "Cola", BigDecimal.valueOf(0.95));
        String data;
        if(drink.equals(true)){
            data = "Chew Chew, Yum!";
        }
        String expected = "Glug Glug, Yum!";
        String actual = drink.dispenseMessage();

        //Assert
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void dispenseMessage_Chip_returnsGlug(){
        ChipItem chip =  new ChipItem("D2", "Potato Crisps", BigDecimal.valueOf(3.05));
        String data;
        if(chip.equals(true)){
            data = "Chew Chew, Yum!";
        }
        String expected = "Crunch Crunch, Yum!";
        String actual = chip.dispenseMessage();

        //Assert
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void dispenseMessage_Candy_returnsMunch(){
        CandyItem candy = new CandyItem("B1", "Moonpie", BigDecimal.valueOf(1.80));
        String data;
        if(candy.equals(true)){
            data = "Chew Chew, Yum!";
        }
        String expected = "Munch Munch, Yum!";
        String actual = candy.dispenseMessage();

        //Assert
        Assert.assertEquals(expected.toString(), actual.toString());
    }

//    @Test
////    @Ignore
////    public void toString_Item_returnsStringSOLDOUT(){
////        //Arrange
////        String expected;
////        item.setInventory(0);
////        System.out.println(item.getInventory());
////
////        if(item.getInventory() != 0) {
////            expected = (item.getSlot() + "|" + item.getName() + "|" + item.getPrice() + "|" + item.getInventory());
////        }
////        else {
////            expected = (item.getSlot() + "|" + item.getName() + "|" + item.getPrice() + "|SOLD OUT").toString();
////        }
////        System.out.println(expected);
////        //Act
////        String actual = item.toString();
////
////        //Assert
////        Assert.assertEquals(expected.toString(), actual.toString());
////    }


}
