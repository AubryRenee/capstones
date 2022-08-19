package com.techelevator.item;

import java.math.BigDecimal;

public class GumItem extends Item{


    public GumItem(String slot, String name, BigDecimal price) {
        super(slot, name, price);
    }

    @Override
    public String dispenseMessage() {
        return "Chew Chew, Yum!";
    }


}
