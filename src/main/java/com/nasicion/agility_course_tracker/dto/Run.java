package com.nasicion.agility_course_tracker.dto;

/**
 * Created by guillermo.nasi on 23/05/2017.
 */
public class Run implements Comparable{
    private Double time;
    private Integer faults;
    private Integer refusals;

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Integer getFaults() {
        return faults;
    }

    public void setFaults(Integer faults) {
        this.faults = faults;
    }

    public Integer getRefusals() {
        return refusals;
    }

    public void setRefusals(Integer refusals) {
        this.refusals = refusals;
    }
}
