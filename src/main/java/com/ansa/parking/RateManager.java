package com.ansa.parking;

import java.math.BigDecimal;
import java.util.*;

public class RateManager {
    class RateWrapper{
        private Rate rate;
        private Rate next;
        private Rate parent;

        public RateWrapper(Rate rate){
            this.rate = rate;
        }

        public void addNext(Rate rate){
            this.next = rate;
        }

        public boolean hasNext(){
            return this.next == null;
        }

        public Rate getNext() {
            return next;
        }

        public Rate getRate(){
            return rate;
        }

        public Rate getParent(){
            return parent;
        }

        public void setPatent(Rate rate){
            this.parent = rate;
        }
    }


    private RateWrapper head;

    private Map<Rate, RateWrapper> rateRateWrapperMap = new HashMap<>();

    private NavigableSet<Rate> rates = new TreeSet<>();
    private Rate DEFAULT_RATE = new Rate(0, 0, 23, 59, RateType.EVENT, new BigDecimal(10));

    public RateManager(){
        rates.add(DEFAULT_RATE);
        RateWrapper defaultRateWrapper = new RateWrapper(DEFAULT_RATE);
        rateRateWrapperMap.put(DEFAULT_RATE, defaultRateWrapper);
        head = new RateWrapper(DEFAULT_RATE);
    }

    public void addRate(Rate rate){
        Rate rateBefore = rates.lower(rate);
        RateWrapper rateWrapper = rateRateWrapperMap.get(rateBefore);
        if (rateWrapper.hasNext()){
            // A - C

        } else {
            if (rate.isInside(rateWrapper.getRate())){
                // A1 - B - A2
                Rate aRate = rateWrapper.getRate();
                Rate bRate = rate;


                //aRate.getFrom(), bRate.getFrom(), bRate.getTo(), aRate.getTo()
                Rate a1Rate = new Rate();
                a1Rate.setFrom(aRate.getFrom());
                a1Rate.setTo(rate.getFrom());
                RateWrapper a1RateWrapper = new RateWrapper(a1Rate);



                Rate bRate = rate;
                Rate a2Rate= new Rate();

            }
            if (rate.startsBefore(rateWrapper.getRate())){
                // B - A
            }

            if (rate.startsInside(rateWrapper.getRate())){
                // AB

            }

        }
   }

    public Collection<Rate> getRates(Period period) {
        Set<Rate> rates = new HashSet<>();
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
        NavigableSet<Rate> rates = new TreeSet<>();
        Rate defaultRate = new Rate(0, 0, 23, 59, RateType.EVENT, new BigDecimal(10));
        rates.add(defaultRate);


    }
}
