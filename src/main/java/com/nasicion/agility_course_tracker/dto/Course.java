package com.nasicion.agility_course_tracker.dto;

/**
 * Created by guillermo.nasi on 23/05/2017.
 */
public class Course {
    private Double lenght;
    private Double standardCourseTime;
    private Double maximiumCourseTime;
    private Double speed;

    public Course(Double lenght, Double standardCourseTime, Double maximiumCourseTime, Double speed) {
        this.lenght = lenght;
        this.standardCourseTime = standardCourseTime;
        this.maximiumCourseTime = maximiumCourseTime;
        this.speed = speed;
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
}
