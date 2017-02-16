package com.ansa.parking;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by asalkov on 2/15/17.
 */
public class RatedPeriodTest {

    @Test
    public void test(){
        Period period = new Period(0, 0, 1, 0);
        Period period1 = new Period(1, 0, 3, 0);

        assertTrue(period.startsBefore(period1));

        Period period2 = new Period(2, 0, 3, 0);

        assertTrue(period1.startsBefore(period2));

        assertTrue(period1.startsBefore(period2));

        assertTrue(period2.endAfterOrSame(period1));

        assertTrue(period2.isInside(period1));


    }
}
