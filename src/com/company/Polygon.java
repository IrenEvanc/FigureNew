package com.company;

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
