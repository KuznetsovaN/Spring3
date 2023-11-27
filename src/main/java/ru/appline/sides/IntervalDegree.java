package ru.appline.sides;

public class IntervalDegree {
    private Integer left;
    private Integer right;

    public IntervalDegree() {
    }

    public IntervalDegree(Integer left, Integer right) {
        this.left = left;
        this.right = right;
    }

    public IntervalDegree(String interval){
        this.left = Integer.valueOf(interval.split("-")[0]);
        this.right = Integer.valueOf(interval.split("-")[1]);
    }

    public Integer getLeft() {
        return left;
    }

    public IntervalDegree setLeft(Integer left) {
        this.left = left;
        return this;
    }

    public Integer getRight() {
        return right;
    }

    public IntervalDegree setRight(Integer right) {
        this.right = right;
        return this;
    }
}