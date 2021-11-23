package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Rectangle extends Polygon{


        public Rectangle (ArrayList<Point> points){
            super(points);
        }

        public static  Rectangle inputRectangle() {

            ArrayList <Point> points = new ArrayList<Point>();
            System.out.println("Введите координаты вершин");
            Scanner in = new Scanner(System.in);
            for (int i=0; i<4; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                points.add(new Point(x,y));
            }
            return  new Rectangle(points);
        }
        //
//    public double getPerimetr () {
//       double perimetr = Math.sqrt(Math.pow(points.get(0).x - points.get(n-1).x, 2) + Math.pow(points.get(0).y - points.get(n-1).y, 2));
//        for (int i=0; i<n-1; i++) {
//            perimetr+=Math.sqrt(Math.pow(points.get(i).x - points.get(i+1).x, 2) + Math.pow(points.get(i).y - points.get(i+1).y, 2));
//            }
//
////        double perimetr = 2*(a+b);
//        return  perimetr;
//    }
////    public double getAree () {
////        double aree = a*b;
////        return aree;
////    }
        @Override
        public String toString () {
        String result = "Прямоугольник с вершинами в точках: " + points.get(0) + " " + points.get(1) + " " + points.get(2) + " " + points.get(3)+"\n " +
                "со следующими характеристиками: \n" + "периметр = " + getPerimetr() + ", \n" + "площадь = " + getArea()+ "\n ";
//            String result = "Прямоугольник с вершинами в точках: ";
//            int n = 4;
//            for (int i=0; i<n; i++) {
//                result += points.get(i) + " ";
////       this.points.forEach(p->System.out.println(p));
//            }
            return result;
        }
//    @Override
//    public void move(Point vect){
//        System.out.println("летаю");
//    }
//
//    @Override
//    public void scale(double angle) {
//
//    }
}
