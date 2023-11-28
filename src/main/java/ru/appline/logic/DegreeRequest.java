package ru.appline.logic;


import com.google.gson.annotations.SerializedName;

public class DegreeRequest {

    @SerializedName("Degree")
    private int degree;

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
}

