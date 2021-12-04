package Figures;

import Interface.IMovable;
import Interface.IRotate;
import Interface.IScale;
import com.company.Point;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Figure implements IMovable, IRotate, IScale {

    ArrayList<Point> points;
    Point center;
    double area;
    double perimetr;

    public Figure(ArrayList<Point> points) {
        this.points = points;
        this.calculateCenter();
        this.calculatePerimetr();
        this.calculateArea();
    }
    public static ArrayList<Point>  input(int size) {
        ArrayList<Point> points = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < size; i++) {
            System.out.println("Введите координаты " + (i + 1) + "-й вершины: ");
            int x = in.nextInt();
            int y = in.nextInt();
            points.add(new Point(x, y));
        }
        System.out.println("***Фигура добавлена***");
        return points;
    }
    public abstract void calculateCenter();

    public Point getCenter() {
        return center;
    }

    public abstract void calculatePerimetr();

    public abstract void calculateArea();

    public double getPerimetr() {
        return perimetr;
    }

    public double getArea() {
        return area;
    }
    public abstract String getName();
    public abstract String toString ();

}

