package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class SebrinaLoggerTests{

 Logger dateLogger = new Logger();


@Test
  public void getCurrentTime_NOW_returnsCurrentTimeFormatted() {
    String data = "MM/dd/yyyy HH:mm:ss a";
    String expected = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a")).toString();
    String actual = dateLogger.getCurrentTime(data);
    Assert.assertEquals(expected.toString(), actual.toString());
}


}
