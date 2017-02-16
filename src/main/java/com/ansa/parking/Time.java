package com.ansa.parking;

import java.util.Objects;

public class Time implements Comparable<Time>{
    private Integer h;
    private Integer m;

    public Time(int h, int m) {
        this.h = h;
        this.m = m;
    }

    public boolean isBefore(Time time){
        if (this.getH() == time.getH()){
            return this.getM() < time.getM();
        }
        return this.getH() < time.getH();
    }

    public boolean isAfter(Time time){
        if (this.getH() == time.getH()){
            return this.getM() > time.getM();
        }
        return this.getH() > time.getH();
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return Objects.equals(h, time.h) &&
                Objects.equals(m, time.m);
    }

    @Override
    public int hashCode() {
        return Objects.hash(h, m);
    }
}
