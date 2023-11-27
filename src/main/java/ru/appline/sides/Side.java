package ru.appline.sides;


public class Side {

    private String side;

    public Side() {
    }

    public Side(String side) {
        this.side = side;
    }

    public String getSide() {
        return side;
    }

    public Side setSide(String side) {
        this.side = side;
        return this;
    }
}