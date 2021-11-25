package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Circle extends Figure {


    private double radius;

    public Circle (ArrayList<Point> points){
        super(points);

        this.calculateRadius();
        this.calculatePerimetr();
        this.calculateArea();
    }
    public static Circle inputCircle (int size) {
        ArrayList <Point> points = new ArrayList<Point>();
        System.out.println("Введите координаты точек");
        Scanner in = new Scanner(System.in);
        for (int i=0; i<size; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            points.add(new Point(x,y));
        }
        return new Circle(points);
    }
    public void calculateRadius() {
        this.radius = Math.sqrt(Math.pow(points.get(0).getX() - points.get(points.size() - 1).getX(), 2)
                + Math.pow(points.get(0).getY() - points.get(points.size() - 1).getY(), 2));
    }
    public double getRadius() {
        return radius;
    }
    @Override
    public void calculatePerimetr() {
       this.perimetr = 2*Math.PI*radius;
    }
    @Override
    public void calculateArea() {
        this.area = Math.PI*Math.pow(radius, 2);
    }
    public double getPerimetr () {
        return  perimetr;
    }
    public double getArea () {
            return area;
    }
    @Override
    public String toString () {
        String result = "Круг с центром в точке A" + points.get(0) + " и радиусом " + radius + "\n " +
                "со следующими характеристиками: \n" + "периметр = " + getPerimetr() + ", \n" + "площадь = " + getArea()+ "\n ";
        return result;
    }
    @Override
    public void move(Point vect){
        System.out.println("двигаюсь");
    }

    @Override
    public void scale(double scale) {
    }

    @Override
    public void rotate(double angle) {

    }
}
