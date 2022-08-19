package com.techelevator.item;

import java.math.BigDecimal;

public class ChipItem extends Item{


    public ChipItem(String slot, String name, BigDecimal price) {
        super(slot, name, price);
    }

    public String dispenseMessage() {
        return "Crunch Crunch, Yum!";
    }

}
