package com.company;

public class Point {
    double x;
    double y;

    public  Point (double x, double y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString () {
        String result = "(" + x + "," + y + ")";
        return result;
    }
}
