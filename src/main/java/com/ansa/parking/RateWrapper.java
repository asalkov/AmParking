package com.ansa.parking;

import java.math.BigDecimal;

public class RateWrapper {
    private RatedPeriod rate;
    private RateWrapper next;
    private RateWrapper parent;

    public RateWrapper(){
        this.rate = new RatedPeriod();
    }
    public RateWrapper(RatedPeriod rate){
        this.rate = rate;
    }

    public void setNext(RateWrapper rate){
        this.next = rate;
    }

    public boolean hasNext(){
        return this.next != null;
    }

    public RateWrapper getNext() {
        return next;
    }

    public RatedPeriod getRate(){
        return rate;
    }

    public RateWrapper getParent(){
        return parent;
    }

    public void setParent(RateWrapper rate){
        this.parent = rate;
    }

    public RateWrapper withPeriodFrom(Time from){
        getRate().setFrom(from);
        return this;
    }

    public RateWrapper withPeriodTo(Time to){
        getRate().setTo(to);
        return this;
    }

    public RateWrapper withRateType(RateType rateType){
        getRate().setRateType(rateType);
        return this;
    }

    public RateWrapper withRate(BigDecimal rate){
        getRate().setRate(rate);
        return this;
    }

    public static RateWrapper black(){
        return new RateWrapper();
    }

    public static RateWrapper create(Time from, Time to){
        RatedPeriod rate = new RatedPeriod();
        rate.setFrom(from);
        rate.setTo(to);
        RateWrapper rateWrapper = new RateWrapper(rate);
        return rateWrapper;
    }
}
