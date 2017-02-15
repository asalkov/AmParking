package com.ansa.parking;

import java.math.BigDecimal;
import java.util.Collection;

public class Parking {

    private RateManager rateManager = new RateManager();

    public void addRate(Rate rate){
        rateManager.addRate(rate);
    }

    public BigDecimal calculatedPrice(Period period){
        Collection<Rate> rates = rateManager.getRates(period);
        return null;
    }

    public static void main(String[] args) {
        Parking parking = new Parking();
        parking.addRate(new Rate(0, 0, 23, 29, RateType.REGULAR, new BigDecimal("10.0")));
        parking.addRate(new Rate(8, 0, 11, 00, RateType.EARLY_BIRD, new BigDecimal("3.5")));


    }
}
