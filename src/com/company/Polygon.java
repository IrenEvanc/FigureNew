package com.company;

import java.util.Scanner;

public class Polygon extends Figure implements IMovable{
    Point pointA;
    Point pointB;
    double a;
    double b;

    public Polygon (Point pointA, Point pointB){
        this.pointA = pointA;
        this.pointB = pointB;
        this.a = Math.abs(pointA.x- pointB.x);
        this.b = Math.abs(pointA.y- pointB.y);
    }
    public static Polygon inputPolygon () {
        System.out.println("Введите координаты вершин");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        Point pointA = new Point(x,y);
        x = in.nextInt();
        y = in.nextInt();
        Point pointB = new Point(x,y);
        return  new Polygon(pointA, pointB);
    }

    public double getPerimetr () {
        double perimetr = a+b;
        return  perimetr;
    }
    public double getAree () {
        double aree = a*b;
        return aree;
    }
    @Override
    public String toString () {
        String result = "Прямоугольник с вершинами в точках: A" + pointA + ", B" + pointB+ "\n " +
                "со следующими характеристиками: \n" + "периметр = " + getPerimetr() + ", \n" + "площадь = " + getAree()+ "\n ";
        return result;
    }
    @Override
    public void move(){
        System.out.println("летаю");
    }
}
