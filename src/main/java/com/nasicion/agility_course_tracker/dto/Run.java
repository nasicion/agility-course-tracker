package com.nasicion.agility_course_tracker.dto;

/**
 * Created by guillermo.nasi on 23/05/2017.
 */
public class Run implements Comparable<Run>{
    private Double time;
    private Integer faults;
    private Integer refusals;

    public Run() {
    }

    public Run(Double time, Integer faults, Integer refusals) {
        this.time = time;
        this.faults = faults;
        this.refusals = refusals;
    }

    @Override
    public int compareTo(Run run) {
        int comparison = 0;
        if(!this.eliminated() && run.eliminated()) {
            comparison = -1;
        }

        if(comparison == 0) {
            comparison = this.totalFaults().compareTo(run.totalFaults());
            if (comparison == 0) {
                return this.time.compareTo(run.getTime());
            } else {
                return comparison;
            }
        } else {
            return comparison;
        }

    }

    public Integer totalFaults() {
        return this.faults + this.refusals;
    }

    public boolean eliminated(){
        return this.refusals >= 3;
    }

    @Override
    public String toString() {
        return "Run{" +
                "time=" + time +
                ", faults=" + faults +
                ", refusals=" + refusals +
                '}';
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
