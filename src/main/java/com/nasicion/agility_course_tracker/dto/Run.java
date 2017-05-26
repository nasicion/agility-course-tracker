package com.nasicion.agility_course_tracker.dto;

import javax.persistence.*;

/**
 * Created by guillermo.nasi on 23/05/2017.
 */
@Entity
@Table(name="run")
public class Run implements Comparable<Run>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="time")
    private Double time;
    @Column(name="faults")
    private Integer faults;
    @Column(name="refusals")
    private Integer refusals;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="course")
    private Course course;

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
                "id=" + id +
                ", time=" + time +
                ", faults=" + faults +
                ", refusals=" + refusals +
                ", course=" + course +
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
