package com.ansa.parking;

public class Time implements Comparable<Time>{
    private Integer h;
    private Integer m;

    public Time(int h, int m) {
        this.h = h;
        this.m = m;
    }

    public boolean isBefore(Time time){
        return this.compareTo(time)<1;
    }

    public boolean isAfter(Time time){
        return this.compareTo(time)>1;
    }


    @Override
    public int compareTo(Time o) {
        int cmt = h.compareTo(o.getH());
        if (cmt==0)
            return m.compareTo(o.getM());
        return cmt;
    }

    public Integer getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Integer getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }
}
