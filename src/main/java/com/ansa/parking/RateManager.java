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
            // A - C => A - B - C/A - B/A[B]-B-C/A[B]-B

        } else {
            if (rate.isInside(rateWrapper.getRate())){
                // A1 - B - A2
                RatedPeriod aRate = rateWrapper.getRate();
                RatedPeriod bRate = rate;


                //aRate.getFrom(), bRate.getFrom(), bRate.getTo(), aRate.getTo()
                RateWrapper a1RateWrapper = RateWrapper.black().withPeriodFrom(aRate.getFrom()).
                                                withPeriodTo(rate.getTo()).
                                                withRateType(aRate.getRateType()).
                                                withRate(aRate.getRate());
                RateWrapper bRateWrapper = new RateWrapper();


                RateWrapper a2RateWrapper = new RateWrapper();

                a1RateWrapper.setNext(bRateWrapper);
                bRateWrapper.setNext(a2RateWrapper);




            }
            if (rate.startsBefore(rateWrapper.getRate())){
                // B - A
            }

            if (rate.startsInside(rateWrapper.getRate())){
                // AB

            }

        }

        rearrangePeriods();
   }

    private void rearrangePeriods() {
        rates.clear();
        RateWrapper wrapper = head;
        while (wrapper.hasNext()){
            rates.add(wrapper.getRate());
        }
    }

    public Collection<RatedPeriod> getRates(Period period) {
        Set<RatedPeriod> rates = new HashSet<>();
        RateWrapper wrapper = getLeftMostWrapper(period);
        RateWrapper last = getRightMostWrapper(period);
        while (wrapper!=last) {
            rates.add(wrapper.getRate());
            wrapper = wrapper.getNext();
        }

        return rates;
    }

    private RateWrapper getRightMostWrapper(Period period) {
        return null;
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
