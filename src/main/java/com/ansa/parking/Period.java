package com.ansa.parking;

public class Period implements Comparable<Period>{
    private Time from;
    private Time to;

    public Period(){

    }

    public Period(int h1, int m1, int h2, int m2) {
        this.from = new Time(h1, m1);
        this.to = new Time(h2, m2);
    }

    public Time getFrom() {
        return from;
    }

    public void setFrom(Time from) {
        this.from = from;
    }

    public Time getTo() {
        return to;
    }

    public void setTo(Time to) {
        this.to = to;
    }

    public boolean startsBefore(Period p){
        return this.compareTo(p)<0;
    }

    public boolean endAfter(Period p){
        return this.compareTo(p)>0;
    }

    @Override
    public int compareTo(Period o) {
        int cmt = from.compareTo(o.getFrom());
        if (cmt==0)
            return from.compareTo(o.getTo());
        return cmt;
    }
}
