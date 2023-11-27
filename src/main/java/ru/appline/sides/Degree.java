package ru.appline.sides;


public class Degree {
    private Integer degree;

    public Degree(Integer degree) {
        this.degree = degree;
    }

    public Degree() {
    }

    public Integer getDegree() {
        if (Math.abs(this.degree) >= 360){
            return Math.abs(degree) % 360;
        }
        return Math.abs(degree);
    }

    public Degree setDegree(Integer degree) {
        this.degree = degree;
        return this;
    }
}