package com.ansa.parking;

import org.junit.Assert;
import org.junit.Test;

public class TimeTest {
    @Test
    public void normal(){
        Time time = new Time(1, 0);
        Time time1 = new Time(1, 5);
        Time time2 = new Time(2, 0);

        Time time3 = new Time(2, 0);

        Assert.assertTrue(time.isBefore(time1));
        Assert.assertTrue(time1.isAfter(time));
        Assert.assertTrue(time2.isAfter(time1));


    }
}
