package com.ansa.parking;

import java.math.BigDecimal;

public class RatedPeriod extends Period{
    private BigDecimal rate;
    private RateType rateType;

    public RatedPeriod(int h1, int m1, int h2, int m2, RateType rateType, BigDecimal rate){
        super(h1, m1, h2, m2);
    }

    public RatedPeriod(){

    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public RateType getRateType() {
        return rateType;
    }

    public void setRateType(RateType rateType) {
        this.rateType = rateType;
    }

    public boolean isInside(RatedPeriod aRate){
        return startsBefore(aRate)&&endAfter(aRate);
    }

    public boolean startsInside(RatedPeriod rate) {
        return this.getFrom().isAfter(rate.getFrom());
    }
}
