package com.techelevator;

import com.techelevator.item.Item;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Logger {
    private final String outFilePath = "log.log";
    private File outFile = new File(outFilePath);



    public String getCurrentTime(String format){ //Sebrina
        LocalDateTime now = LocalDateTime.now();

        // Create a DateTimeFormatter using a format String
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

        // format the LocalDateTime into a String
        return formatter.format(now);

    }

    public void logFeedMoney(BigDecimal currentMoney, BigDecimal insertedMoney){ // Aubry
        try (PrintWriter writer = new PrintWriter(new FileOutputStream (outFile, true))) {
           String logLine = (getCurrentTime("MM/dd/yyyy HH:mm:ss a") + " FEED MONEY: $" + insertedMoney.setScale(2, RoundingMode.HALF_UP) + " $" + currentMoney.setScale(2, RoundingMode.HALF_UP));
           writer.println(logLine);
        } catch (FileNotFoundException ex) {
            System.out.println("Error writing log" + ex.getMessage());
        }


    }
    public void logPurchaseItem(Item purchasedItem, BigDecimal currentMoney){ // Aubry
        try (PrintWriter writer = new PrintWriter(new FileOutputStream (outFile, true))) {
            String logLine = (getCurrentTime("MM/dd/yyyy HH:mm:ss a") + " " + purchasedItem.getName() + " " + purchasedItem.getSlot() + " $" + purchasedItem.getPrice() + " $" + currentMoney.setScale(2, RoundingMode.HALF_UP));
            writer.println(logLine);
        } catch (FileNotFoundException ex) {
            System.out.println("Error writing log" + ex.getMessage());
        }


    }
    public void logFinishTransaction(BigDecimal currentMoney, BigDecimal remainingBalance){ // Aubry
        try (PrintWriter writer = new PrintWriter(new FileOutputStream (outFile, true))) {
            String logLine = (getCurrentTime("MM/dd/yyyy HH:mm:ss a") + " GIVE CHANGE: $" + remainingBalance.setScale(2, RoundingMode.HALF_UP) + " $" + currentMoney.setScale(2, RoundingMode.HALF_UP));
            writer.println(logLine);
        } catch (FileNotFoundException ex) {
            System.out.println("Error writing log" + ex.getMessage());
        }

    }
    public File generateSalesReport(Map<String, Item> itemList) { //Davin
        String salesReport = "sales_report_" + getCurrentTime("MM-dd-yyyy_HHmmss_a") + ".log";
        File salesFile = new File(salesReport);
        if(itemList != null) {
            try (PrintWriter writer = new PrintWriter(salesFile)) {
                BigDecimal totalSales = BigDecimal.ZERO;
                int fullInventory = Item.getSTARTING_INVENTORY();
                for (Map.Entry<String, Item> entry : itemList.entrySet()) {
                    int soldItems = fullInventory - entry.getValue().getInventory();
                    String salesLine = (entry.getValue().getName() + "|" + soldItems);
                    writer.println(salesLine);
                    totalSales = totalSales.add(entry.getValue().getPrice().multiply(BigDecimal.valueOf(soldItems)));
                }
                writer.println("**TOTAL SALES** $" + totalSales.setScale(2, RoundingMode.HALF_UP));
            } catch (FileNotFoundException ex) {
                System.out.println("Error writing log" + ex.getMessage());
            }
        }
        return salesFile;
    }

}
