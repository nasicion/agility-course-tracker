package com.nasicion.agility_course_tracker.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by guillermo.nasi on 23/05/2017.
 */
@Entity
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String judge;
    @Column
    private Date date;
    @Column
    private Double lenght;
    @Column
    private Double standardCourseTime;
    @Column
    private Double maximiumCourseTime;
    @Column
    private Double speed;
    @OneToMany(mappedBy = "course")
    private List<Run> runs;

    public Course(String judge, Date date, Double lenght, Double standardCourseTime, Double maximiumCourseTime, Double speed) {
        this.judge = judge;
        this.date = date;
        this.lenght = lenght;
        this.standardCourseTime = standardCourseTime;
        this.maximiumCourseTime = maximiumCourseTime;
        this.speed = speed;
        this.runs = new ArrayList<Run>();
    }

    public Course() {

    }

    public Double getLenght() {
        return lenght;
    }

    public void setLenght(Double lenght) {
        this.lenght = lenght;
    }

    public Double getStandardCourseTime() {
        return standardCourseTime;
    }

    public void setStandardCourseTime(Double standardCourseTime) {
        this.standardCourseTime = standardCourseTime;
    }

    public Double getMaximiumCourseTime() {
        return maximiumCourseTime;
    }

    public void setMaximiumCourseTime(Double maximiumCourseTime) {
        this.maximiumCourseTime = maximiumCourseTime;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Run> getRuns() {
        return runs;
    }

    public void setRuns(List<Run> runs) {
        this.runs = runs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
