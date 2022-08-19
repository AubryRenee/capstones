package com.techelevator;

import com.techelevator.item.Item;
import org.junit.Assert;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.*;
import java.math.BigDecimal;
import java.util.Map;

public class AubryLoggerTests {
    private Logger logger = new Logger();
    private final String testFilePath = "log.log";
    private File testFile = new File(testFilePath);

    InputStreamReader streamReader =
            new InputStreamReader(new FileInputStream(testFile));



    public AubryLoggerTests() throws FileNotFoundException {
    }


        @Test
        public void logFeedMoney_should_append_log_correctly () {

            //Arrange
            BigDecimal testCurrentMoney = BigDecimal.valueOf(7.50);
            BigDecimal testInsertedMoney = BigDecimal.valueOf(5.00);
            String expected = logger.getCurrentTime("MM/dd/yyyy HH:mm:ss a") + " FEED MONEY: $5.00 $7.50";
            String actual = "";

            //Act
            logger.logFeedMoney(testCurrentMoney, testInsertedMoney);

            BufferedReader br = new BufferedReader(streamReader);
            for (int i = 0; i < testFile.length(); i++) {

                try {
                    String temp = br.readLine();
                    if (temp != null) {
                        actual = temp;
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            //Assert
            Assert.assertEquals(expected, actual);
        }


        @Test
        public void logFinishTransaction_should_append_log_correctly () {

            //Arrange
            BigDecimal testCurrentMoney = BigDecimal.valueOf(0.00);
            BigDecimal testRemainingBalance = BigDecimal.valueOf(1.00);


            String expected = logger.getCurrentTime("MM/dd/yyyy HH:mm:ss a ") + "GIVE CHANGE: $1.00 $0.00";
            String actual = "";

            //Act
            logger.logFinishTransaction(testCurrentMoney, testRemainingBalance);

            BufferedReader br = new BufferedReader(streamReader);
            for (int i = 0; i < testFile.length(); i++) {

                try {
                    String temp = br.readLine();
                    if (temp != null) {
                        actual = temp;
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            //Assert
            Assert.assertEquals(expected, actual);
        }

        /*
       @Test
        public void logPurchaseItem_should_append_log_correctly () {

            //Arrange
            VendingMachine vendingMachine = new VendingMachine();
            BigDecimal testInsertedMoney = BigDecimal.valueOf(5.00);
            Item testPurchasedItem = vendingMachine.getInventoryItems().get(Item.);
            String expected = logger.getCurrentTime("MM/dd/yyyy HH:mm:ss a ") + "FEED MONEY: $5.00 $7.50";
            String actual = "";

            //Act
            logger.logPurchaseItem(testPurchasedItem, testInsertedMoney);

            BufferedReader br = new BufferedReader(streamReader);
            for (int i = 0; i < testFile.length(); i++) {

                try {
                    String temp = br.readLine();
                    if (temp != null) {
                        actual = temp;
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            //Assert
            Assert.assertEquals(expected, actual);
        } */
}
