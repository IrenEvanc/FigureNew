package com.company;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Triangle extends Polygon {
//
//    private double AB;
//    private double BC;
//    private double AC;

    public Triangle (ArrayList<Point> points){
        super(points);
    }
//    public void calculateSides () {
//        this.AB = Math.sqrt(Math.pow(pointA.x - pointB.x, 2) + Math.pow(pointA.y - pointB.y, 2));
//        this.BC = Math.sqrt(Math.pow(pointB.x - pointC.x, 2) + Math.pow(pointB.y - pointC.y, 2));
//        this.AC = Math.sqrt(Math.pow(pointA.x - pointC.x, 2) + Math.pow(pointA.y - pointC.y, 2));
//    }
    public static Triangle inputTriangl () {
        ArrayList <Point> points = new ArrayList<>();
        System.out.println("Введите координаты вершин треугольника");
        Scanner in = new Scanner(System.in);
        for (int i=0; i<3; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            points.add(new Point(x,y));
        }
        return new Triangle(points);
    }
//    public double getPerimetr () {
//        double perimetr = AB + BC + AC;
//        return  perimetr;
//    }
//    public double getAree () {
//        double halfPerimetr = getPerimetr()/2;
//        double aree = Math.sqrt(halfPerimetr+(halfPerimetr-AB)+(halfPerimetr-BC)+(halfPerimetr-AC));
//        return aree;
////        return Math.abs((pointB.x-pointA.x)*(pointC.y-pointA.y)-(pointC.x-pointA.x)*(pointB.y-pointA.y));
//    }
    @Override
    public String toString () {
        String result = "Треугольник с вершинами в точках: A" + points.get(0) + ", B" + points.get(1) + ", C" + points.get(2) + "\n " +
                "со следующими характеристиками: \n" + "периметр = " + getPerimetr() + ", \n" + "площадь = " + getArea()+ "\n ";
        return result;
    }
//    @Override
//    public void move(Point vect){
//        System.out.println("плаваю");
//    }
//    public double getBC() {
//        return BC;
//    }
//    public double getAB() {
//        return AB;
//    }
//    public double getAC() {
//        return AC;
//    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Triangle triangle = (Triangle) o;
//        return pointA.equals(triangle.pointA) && pointB.equals(triangle.pointB) && pointC.equals(triangle.pointC);
//    }
//    @Override
//    public int hashCode() {
//        return Objects.hash(pointA, pointB, pointC);
//    }
//
////    @Override
//    public void scale(double angle) {
//
//    }
}
