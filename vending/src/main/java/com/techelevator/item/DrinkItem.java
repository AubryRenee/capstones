package com.techelevator.item;

import java.math.BigDecimal;

public class DrinkItem extends Item{


    public DrinkItem(String slot, String name, BigDecimal price) {
        super(slot, name, price);
    }

    public String dispenseMessage() {
        return "Glug Glug, Yum!";
    }

}
