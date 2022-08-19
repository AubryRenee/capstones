package com.techelevator.item;

import java.math.BigDecimal;

public class CandyItem extends Item{


    public CandyItem(String slot, String name, BigDecimal price) {
        super(slot, name, price);
    }

    @Override
    public String dispenseMessage() {
        return "Munch Munch, Yum!";
    }


}
