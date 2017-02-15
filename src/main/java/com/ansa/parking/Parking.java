package com.ansa.parking;

import java.math.BigDecimal;
import java.util.Collection;

public class Parking {

    private RateManager rateManager = new RateManager();

    public void addRate(RatedPeriod rate){
        rateManager.addRate(rate);
    }

    public BigDecimal calculatedPrice(Period period){
        Collection<RatedPeriod> rates = rateManager.getRates(period);
        return null;
    }

    public static void main(String[] args) {
        Parking parking = new Parking();
        parking.addRate(new RatedPeriod(0, 0, 23, 29, RateType.REGULAR, new BigDecimal("10.0")));
        parking.addRate(new RatedPeriod(8, 0, 11, 00, RateType.EARLY_BIRD, new BigDecimal("3.5")));


    }
}
