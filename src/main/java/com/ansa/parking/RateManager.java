package com.ansa.parking;

import java.math.BigDecimal;
import java.util.*;

public class RateManager {
    private RateWrapper head;

    private Map<RatedPeriod, RateWrapper> rateRateWrapperMap = new HashMap<>();

    private NavigableSet<RatedPeriod> rates = new TreeSet<>();
    private RatedPeriod DEFAULT_RATE = new RatedPeriod(0, 0, 23, 59, RateType.EVENT, new BigDecimal(10));

    public RateManager(){
        rates.add(DEFAULT_RATE);
        RateWrapper defaultRateWrapper = new RateWrapper(DEFAULT_RATE);
        rateRateWrapperMap.put(DEFAULT_RATE, defaultRateWrapper);
        head = new RateWrapper(DEFAULT_RATE);
    }

    public void addRate(RatedPeriod rate){
        RatedPeriod rateBefore = rates.lower(rate);
        RateWrapper rateWrapper = rateRateWrapperMap.get(rateBefore);
        if (rateWrapper.hasNext()){
            // A - C

        } else {
            if (rate.isInside(rateWrapper.getRate())){
                // A1 - B - A2
                RatedPeriod aRate = rateWrapper.getRate();
                RatedPeriod bRate = rate;


                //aRate.getFrom(), bRate.getFrom(), bRate.getTo(), aRate.getTo()
                RatedPeriod a1Rate = new RatedPeriod();
                a1Rate.setFrom(aRate.getFrom());
                a1Rate.setTo(rate.getFrom());
                RateWrapper a1RateWrapper = RateWrapper.black().withPeriodFrom(aRate.getFrom()).
                                                withPeriodTo(rate.getTo()).
                                                withRateType(a1Rate.getRateType()).
                                                withRate(a1Rate.getRate());




                RatedPeriod a2Rate= new RatedPeriod();

            }
            if (rate.startsBefore(rateWrapper.getRate())){
                // B - A
            }

            if (rate.startsInside(rateWrapper.getRate())){
                // AB

            }

        }
   }

    public Collection<RatedPeriod> getRates(Period period) {
        Set<RatedPeriod> rates = new HashSet<>();
        RateWrapper wrapper = getLeftMostWrapper(period);
        while (wrapper.hasNext()) {
            rates.add(wrapper.getNext());
        }

        return rates;
    }

    private RateWrapper getLeftMostWrapper(Period period) {
        return null;
    }

    public static void main(String[] args) {
        NavigableSet<RatedPeriod> rates = new TreeSet<>();
        RatedPeriod defaultRate = new RatedPeriod(0, 0, 23, 59, RateType.EVENT, new BigDecimal(10));
        rates.add(defaultRate);


    }
}
