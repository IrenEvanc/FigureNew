package com.company;

import java.util.Scanner;

public class Circle extends Figure implements IMovable{
    Point center;
    double radius;

    public Circle (Point center, double radius){
        this.center = center;
        this.radius = radius;
    }
    public static Circle inputCircle () {
        System.out.println("Введите координаты центра и радиус окружности");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        Point center = new Point(x,y);
        double radius = in.nextDouble();
        return  new Circle(center, radius);
    }
    public double getPerimetr () {
        double perimetr = 2*Math.PI*radius;
        return  perimetr;
    }
    public double getAree () {

        double aree = Math.PI*Math.pow(radius, 2);
        return aree;
    }
    @Override
    public String toString () {
        String result = "Круг с центром в точке A" + center + " и радиусом " + radius + "\n " +
                "со следующими характеристиками: \n" + "периметр = " + getPerimetr() + ", \n" + "площадь = " + getAree()+ "\n ";
        return result;
    }
    @Override
    public void move(){
        System.out.println("двигаюсь");
    }
}
