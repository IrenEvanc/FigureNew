package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        Triangle t = new Triangle(new Point(5,6), new Point(2, 1), new Point(3, 5));
        Triangle t1 = new Triangle(new Point(1,3), new Point(2, 5), new Point(3, 4));
        Triangle t2 = new Triangle(new Point(0,6), new Point(2, 2), new Point(3, 5));
        Polygon n = new Polygon(new Point (8,5), new Point(1, 5));
        Circle c = new Circle(new Point(4, 5), 5);

    //    System.out.println(t);
        ArrayList <Figure> figures = new ArrayList<>();
        Collections.addAll(figures, t, t1, t2, n, c);
        for (Figure f: figures) {
        System.out.println(f);
        }
//        ArrayList <IMovable> figures = new ArrayList<>();
//        Collections.addAll(figures, t, t1, t2, n, c);
//        for (IMovable f: figures) {
//            f.move();
//        }
    }
}
