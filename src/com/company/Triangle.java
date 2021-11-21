package com.company;

import java.util.Objects;
import java.util.Scanner;

public class Triangle extends Figure implements IMovable{
    protected Point pointA;
    protected Point pointB;
    protected Point pointC;
    private double AB;
    private double BC;
    private double AC;

    public Triangle(Point pointA, Point pointB, Point pointC){
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.calculateSides();
    }
    public void calculateSides () {
        this.AB = Math.sqrt(Math.pow(pointA.x - pointB.x, 2) + Math.pow(pointA.y - pointB.y, 2));
        this.BC = Math.sqrt(Math.pow(pointB.x - pointC.x, 2) + Math.pow(pointB.y - pointC.y, 2));
        this.AC = Math.sqrt(Math.pow(pointA.x - pointC.x, 2) + Math.pow(pointA.y - pointC.y, 2));
    }

    public static Triangle inputTriangl () {
        System.out.println("Введите координаты вершин треугольника");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        Point pointA = new Point(x,y);
        x = in.nextInt();
        y = in.nextInt();
        Point pointB = new Point(x,y);
        x = in.nextInt();
        y = in.nextInt();
        Point pointC = new Point(x,y);
        return new Triangle(pointA, pointB, pointC);
    }

    public double getPerimetr () {
        double perimetr = AB + BC + AC;
        return  perimetr;
    }
    public double getAree () {
        double halfPerimetr = getPerimetr()/2;
        double aree = Math.sqrt(halfPerimetr+(halfPerimetr-AB)+(halfPerimetr-BC)+(halfPerimetr-AC));
        return aree;
    }

    @Override
    public String toString () {
        String result = "Треугольник с вершинами в точках: A" + pointA + ", B" + pointB + ", C" + pointC + "\n " +
                "со следующими характеристиками: \n" + "периметр = " + getPerimetr() + ", \n" + "площадь = " + getAree()+ "\n ";
        return result;
    }
    @Override
    public void move(){
        System.out.println("плаваю");
    }

    public double getBC() {
        return BC;
    }

    public double getAB() {
        return AB;
    }

    public double getAC() {
        return AC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return pointA.equals(triangle.pointA) && pointB.equals(triangle.pointB) && pointC.equals(triangle.pointC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointA, pointB, pointC);
    }
}
