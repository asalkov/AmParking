package com.ansa.parking;

import java.math.BigDecimal;

public class RateWrapper {
    private RatedPeriod rate;
    private RatedPeriod next;
    private RatedPeriod parent;

    public RateWrapper(){
        this.rate = new RatedPeriod();
    }
    public RateWrapper(RatedPeriod rate){
        this.rate = rate;
    }

    public void addNext(RatedPeriod rate){
        this.next = rate;
    }

    public boolean hasNext(){
        return this.next == null;
    }

    public RatedPeriod getNext() {
        return next;
    }

    public RatedPeriod getRate(){
        return rate;
    }

    public RatedPeriod getParent(){
        return parent;
    }

    public void setPatent(RatedPeriod rate){
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
