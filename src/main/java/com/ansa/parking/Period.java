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
        return this.getFrom().isBefore(p.getFrom());
    }

    public boolean endAfter(Period p){
        return this.getTo().isAfter(p.getTo());
    }

    public boolean endAfterOrSame(Period p) {
        if (this.getTo().isAfter(p.getTo()))
            return true;

        if (this.getTo().equals(p.getTo()))
            return true;

        return false;
    }

    @Override
    public int compareTo(Period o) {
        int cmt = from.compareTo(o.getFrom());
        if (cmt==0)
            return from.compareTo(o.getTo());
        return cmt;
    }
    public boolean isInside(Period aRate){
        return aRate.startsBefore(this)&&this.endAfterOrSame(aRate);
    }

    public boolean startsInside(Period rate) {
        return this.getFrom().isAfter(rate.getFrom());
    }
}
