package com.techelevator.item;

import java.math.BigDecimal;

public abstract class Item { // Sebrina


    private String name;
    private BigDecimal price;
    private String slot;
    private static final int STARTING_INVENTORY = 5;
    private int inventory = STARTING_INVENTORY;


    public Item(String slot, String name, BigDecimal price){
        this.slot = slot;
        this.name = name;
        this.price = price;
    }

    public void dispenseItem() {
        inventory--;
    }

    public abstract String dispenseMessage();

    @Override
    public String toString(){
        if(inventory != 0) {
            return slot + "|" + name + "|" + price + "|" + inventory;
        }
        return slot + "|" + name + "|" + price + "|SOLD OUT";
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getSlot() {
        return slot;
    }

    public int getInventory(){
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public static int getSTARTING_INVENTORY() {
        return STARTING_INVENTORY;
    }


}
