package com.nasicion.agility_course_tracker.model;

/**
 * Created by gnasi on 6/8/17.
 */
public enum Qualification {
    EXCELENTE(0.0, 5.99),
    MUY_BUENO(6.0, 15.99),
    BUENO(16.0, 25.99),
    NO_CLASIFICA(26.0, Double.MAX_VALUE),
    ELIMINADO(null, null);

    private Double floor;
    private Double ciel;

    Qualification(Double floor, Double ciel) {
        this.floor = floor;
        this.ciel = ciel;
    }

    public double getFloor() {
        return floor;
    }

    public void setFloor(double floor) {
        this.floor = floor;
    }

    public double getCiel() {
        return ciel;
    }

    public void setCiel(double ciel) {
        this.ciel = ciel;
    }

    public static Qualification getQualification(Double points) {
        Qualification q = null;

        if(points != null) {
            for(Qualification qualif : Qualification.values()) {
                if((qualif.getFloor() <= points) && (points <= qualif.getCiel())) {
                    q = qualif;
                    break;
                }
            }
        }
        return q;
    }
}
