package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Circle extends Figure {

    private double radius;

    public Circle (ArrayList<Point> points){
        super(points);
    }
    public static Circle inputCircle () {
        ArrayList <Point> points = new ArrayList<Point>();
        System.out.println("Введите координаты центра и радиус окружности");
        Scanner in = new Scanner(System.in);
        for (int i=0; i<2; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            points.add(new Point(x,y));
        }
        return new Circle(points);
    }
//    @Override
//    public void calculatePerimetr() {
//        double perimetr = 2*Math.PI*radius;
//    }
//    @Override
//    public void calculateArea() {
//        double area = Math.PI*Math.pow(radius, 2);
//    }
//    public double getPerimetr () {
//        return  perimetr;
//    }
//    public double getAree () {
//            return area;
//    }
//    @Override
//    public String toString () {
//        String result = "Круг с центром в точке A" + center + " и радиусом " + radius + "\n " +
//                "со следующими характеристиками: \n" + "периметр = " + getPerimetr() + ", \n" + "площадь = " + getAree()+ "\n ";
//        return result;
//    }
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
