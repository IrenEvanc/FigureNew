package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Figure implements IMovable, IRotate, IScale {

    ArrayList<Point> points;
    Point center;
    double area;
    double perimetr;

    public Figure(ArrayList<Point> points) {
        this.points = points;
    }

    public Point getCenter() {
        return center;
    }

    public void calculatePerimetr() {
    }
    public void calculateArea() {

    }
    public double getPerimetr() {
        return perimetr;
    }

    public double getArea() {
        return area;
    }

}

