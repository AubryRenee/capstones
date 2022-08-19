package com.techelevator;

import com.techelevator.item.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.TreeMap;

public class DataLoaderTests {
    DataLoader dataLoader = new DataLoader();
    String testFilePath = "src/test/java/com/techelevator/dataLoaderTestData.txt";
    File testFile = new File(testFilePath);
    Map<String, Item> actual;
    Map<String, Item> expected = new TreeMap<>();

    @Test
    public void loadInventory_happyCase_returnsCorrectMap(){
        //Arrange
        try(PrintWriter writer = new PrintWriter(testFile)){
            writer.println("A2|Stackers|1.45|Chip");
            writer.println("B2|Cowtales|1.50|Candy");
            writer.println("C2|Dr. Salt|1.50|Drink");
            writer.println("D2|Little League Chew|0.95|Gum");

        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        expected.put("A2", new ChipItem("A2", "Stackers", BigDecimal.valueOf(1.45)));
        expected.put("B2", new CandyItem("B2", "Cowtales", BigDecimal.valueOf(1.50).setScale(2, RoundingMode.HALF_UP)));
        expected.put("C2", new DrinkItem("C2", "Dr. Salt", BigDecimal.valueOf(1.50).setScale(2, RoundingMode.HALF_UP)));
        expected.put("D2", new GumItem("D2", "Little League Chew", BigDecimal.valueOf(0.95)));

        //Act
        actual = dataLoader.loadInventory(testFilePath);

        //Assert
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void loadInventory_emptyMap_returnsEmptyMap(){
        //Arrange
        try(PrintWriter writer = new PrintWriter(testFile)){

        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        //Act
        actual = dataLoader.loadInventory(testFilePath);

        //Assert
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void loadInventory_incorrectFilePath_returnsEmptyMap(){
        //Arrange

        //Act
        actual = dataLoader.loadInventory("randoma.txt");

        //Assert
        Assert.assertEquals(expected.toString(), actual.toString());
    }
}
