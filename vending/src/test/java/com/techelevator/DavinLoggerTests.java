package com.techelevator;

import com.techelevator.item.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DavinLoggerTests {
    private Logger logger = new Logger();
    private Map<String, Item> givenMap = new TreeMap<>();

    @Test
    public void generateSalesReport_happyCase_returnsCorrectFile(){
        //Arrange
        givenMap.put("A2", new ChipItem("A2", "Stackers", BigDecimal.valueOf(1.45)));
        givenMap.put("B2", new CandyItem("B2", "Cowtales", BigDecimal.valueOf(1.50).setScale(2, RoundingMode.HALF_UP)));
        givenMap.put("C2", new DrinkItem("C2", "Dr. Salt", BigDecimal.valueOf(1.50).setScale(2, RoundingMode.HALF_UP)));
        givenMap.put("D2", new GumItem("D2", "Little League Chew", BigDecimal.valueOf(0.95)));
        givenMap.get("B2").setInventory(2);
        String expected = "Stackers|0Cowtales|3Dr. Salt|0Little League Chew|0**TOTAL SALES** $4.50";
        String actual = "";

        //Act
        File actualFile = logger.generateSalesReport(givenMap);

        //Assert
        try(Scanner actualScan = new Scanner(actualFile)){
            while(actualScan.hasNextLine()){
                actual += actualScan.nextLine();
            }
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void generateSalesReport_emptyMap_returnsCorrectFile(){
        //Arrange
        String expected = "**TOTAL SALES** $0.00";
        String actual = "";

        //Act
        File actualFile = logger.generateSalesReport(givenMap);

        //Assert
        try(Scanner actualScan = new Scanner(actualFile)){
            while(actualScan.hasNextLine()){
                actual += actualScan.nextLine();
            }
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void generateSalesReport_nullMap_returnsCorrectFile(){
        //Arrange
        givenMap = null;
        String expected = "**TOTAL SALES** $0.00";
        String actual = "";

        //Act
        File actualFile = logger.generateSalesReport(givenMap);

        //Assert
        try(Scanner actualScan = new Scanner(actualFile)){
            while(actualScan.hasNextLine()){
                actual += actualScan.nextLine();
            }
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        Assert.assertEquals(expected, actual);

    }
}
