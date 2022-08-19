package com.techelevator;
import com.techelevator.item.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class VendingMachine {
    private final String filePath = "vendingmachine.csv";
    private DataLoader dataLoader;
    private Map<String, Item>  inventoryItems;
    private BigDecimal currentMoney = BigDecimal.valueOf(0.00);
    private Logger logger = new Logger();

    public VendingMachine() {
        dataLoader = new DataLoader();
        inventoryItems = dataLoader.loadInventory(filePath);
    }
    public VendingMachine(BigDecimal startingMoney) {
        dataLoader = new DataLoader();
        inventoryItems = dataLoader.loadInventory(filePath);
        currentMoney = startingMoney;
    }

    public boolean displayItems(){ //Sebrina
        for (Map.Entry<String, Item> entry : inventoryItems.entrySet()){
            System.out.println(entry.getValue());
        }
        return true;
    }

    public BigDecimal feedMoney(BigDecimal insertedMoney){ //Sebrina
        currentMoney = currentMoney.add(insertedMoney);
        logger.logFeedMoney(currentMoney, insertedMoney);
        return currentMoney;
    }

    public String purchaseItem(String slotNumber) { // Aubry
        Item purchasedItem = inventoryItems.get(slotNumber);
        if (purchasedItem.getInventory() != 0) {
            if (currentMoney.compareTo(purchasedItem.getPrice()) == 1 ) {
                purchasedItem.dispenseItem();
                currentMoney = currentMoney.subtract(purchasedItem.getPrice());
                System.out.println(purchasedItem.getName() + "|" + purchasedItem.getPrice());
                logger.logPurchaseItem(purchasedItem, currentMoney);
                return purchasedItem.dispenseMessage();
            } else {
                return "Insufficient funds";
            }
        }
        return "Product sold out, please choose another item";
    }

    public String returnChange(){ // Davin
        BigDecimal change = currentMoney;

        int quarter = (currentMoney.divide(BigDecimal.valueOf(.25))).intValue();
        currentMoney = currentMoney.subtract(BigDecimal.valueOf(quarter * .25));
        int dime = (currentMoney.divide(BigDecimal.valueOf(.10))).intValue();
        currentMoney = currentMoney.subtract(BigDecimal.valueOf(dime * .10));
        int nickel = (currentMoney.divide(BigDecimal.valueOf(.05))).intValue();
        currentMoney = currentMoney.subtract(BigDecimal.valueOf(nickel * .05));
        logger.logFinishTransaction(change, currentMoney);

        return "Your Change is $" + change.setScale(2, RoundingMode.HALF_UP) + " \nDispensing " + quarter + " quarters " + dime + " dimes " + nickel + " nickels.";
    }

    public BigDecimal getCurrentMoney() {
        return currentMoney;
    }

    public Map<String, Item> getInventoryItems() {
        return inventoryItems;
    }
}
