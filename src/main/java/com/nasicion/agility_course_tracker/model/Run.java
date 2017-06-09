package com.nasicion.agility_course_tracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    @Column(name="course_id")
    private Long courseId;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "category")
    private Category category;
    @Column(name = "position")
    private Integer position;
    @Column(name = "guide")
    private String guide;
    @Column(name = "dog")
    private String dog;

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
                ", courseId=" + courseId +
                ", category=" + category +
                ", position=" + position +
                ", guide='" + guide + '\'' +
                ", dog='" + dog + '\'' +
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

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Category getCategory() {
        return category;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public String getDog() {
        return dog;
    }

    public void setDog(String dog) {
        this.dog = dog;
    }
}
