package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Polygon extends Figure {

    public Polygon(ArrayList<Point> points) {

        super(points);
        this.calculateCenter();
        this.calculatePerimetr();
        this.calculateArea();
    }

    public void calculateCenter() {
        double sumX = 0;
        double sumY = 0;
        for (int i = 0; i < points.size(); i++) {
            sumX += points.get(i).getX();
            sumY += points.get(i).getY();
        }
        this.center = new Point(sumX / points.size(), sumY / points.size());
    }

    public void calculatePerimetr() {
        perimetr = Math.sqrt(Math.pow(points.get(0).getX() - points.get(points.size() - 1).getX(), 2)
                + Math.pow(points.get(0).getY() - points.get(points.size() - 1).getY(), 2));
        for (int i = 0; i < points.size() - 1; i++) {
            perimetr += Math.sqrt(Math.pow(points.get(i).getX() - points.get(i + 1).getX(), 2)
                    + Math.pow(points.get(i).getY() - points.get(i + 1).getY(), 2));
        }
    }

    public void calculateArea() {
        area = points.get(points.size()-1).getX() * points.get(0).getY()
                - points.get(points.size()-1).getY() * points.get(0).getX();
        for (int i = 0; i < points.size()-1; i++) {
            area += points.get(i).getX() * points.get(i + 1).getY()
                    - points.get(i).getY() * points.get(i + 1).getX();
        }
        area = 0.5 * Math.abs(area);
    }

    @Override
    public void move(Point vect) {
        for (int i = 0; i < points.size(); i++) {
            points.set(i, new Point(points.get(i).getX() + vect.getX(),
                    points.get(i).getY() + vect.getY()));
        }
    }

    @Override
    public void rotate(double angle) {
        angle = angle * Math.PI / 180;
        for (int i = 1; i < points.size(); i++) {
            double x = (points.get(i).getX() - center.getX()) * Math.cos(angle) - (points.get(i).getY() - center.getY()) * Math.sin(angle);
            double y = (points.get(i).getX() - center.getX()) * Math.sin(angle) + (points.get(i).getY() - center.getY()) * Math.cos(angle);
            points.set(i, new Point(x, y));
        }
    }

    @Override
    public void scale(double scale) {
        for (int i = 1; i < points.size(); i++) {
            double x = (points.get(i).getX() - center.getX()) * scale + center.getX();
            double y = (points.get(i).getX() - center.getX()) * scale + center.getY();
            points.set(i, new Point(x, y));
        }
    }
//
//    public static ArrayList<Point> input(int size) {
//        ArrayList<Point> points = new ArrayList<>();
//        System.out.println("Введите координаты вершин");
//        Scanner in = new Scanner(System.in);
//        for (int i = 0; i < size; i++) {
//            int x = in.nextInt();
//            int y = in.nextInt();
//            points.add(new Point(x, y));
//        }
//        return points;
//    }
}
