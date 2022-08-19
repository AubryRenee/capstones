package com.techelevator;


import com.techelevator.item.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DataLoader {
    private final int TYPE = 3;

    public Map<String, Item> loadInventory(String filePath) {

        Map<String, Item> inventory = new TreeMap<>();

        File file = new File(filePath);

        try (Scanner scan = new Scanner(file)) {
            String currentLine;

            while (scan.hasNextLine()) {
               currentLine = scan.nextLine();
               String[] itemData = currentLine.split("\\|");
               BigDecimal price = new BigDecimal(itemData[2]);

               if (itemData[TYPE].equalsIgnoreCase("Candy")) {
                   CandyItem candy = new CandyItem(itemData[0], itemData[1], price);
                   inventory.put(itemData[0], candy);
               }else if(itemData[TYPE].equalsIgnoreCase("Gum")) {
                   GumItem gum = new GumItem(itemData[0], itemData[1], price);
                   inventory.put(itemData[0], gum);
               }else if(itemData[TYPE].equalsIgnoreCase("Drink")) {
                   DrinkItem drink = new DrinkItem(itemData[0], itemData[1], price);
                   inventory.put(itemData[0], drink);
               }else if(itemData[TYPE].equalsIgnoreCase("Chip")) {
                   ChipItem chip = new ChipItem(itemData[0], itemData[1], price);
                   inventory.put(itemData[0], chip);
               }

            }

        } catch (FileNotFoundException ex) {
            System.out.println("file error " + ex.getMessage());
        }
        return inventory;
    }


}
