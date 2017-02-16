package com.ansa.parking;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by asalkov on 2/15/17.
 */
public class RateManagerTest {
    @Test
    public void test(){
        RateManager rateManager = new RateManager();
        rateManager.addRate(new RatedPeriod(3, 0, 4, 0, RateType.EARLY_BIRD, BigDecimal.ONE));

        RateWrapper head = rateManager.head();

        assertEquals(new Time(0, 0), head.getRate().getFrom());
        System.out.println(head.getNext().getRate().getFrom());
        assertEquals(new Time(3, 0), head.getNext().getRate().getFrom());
        assertEquals(new Time(4, 0), head.getNext().getNext().getRate().getFrom());
        assertNull(head.getNext().getNext().getNext());



    }
}
