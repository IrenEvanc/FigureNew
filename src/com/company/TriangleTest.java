package com.company;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    Point pointA = new Point(0,0);
    Point pointB = new Point(4, 0);
    Point pointC = new Point(0, 3);
    Triangle t = new Triangle(pointA, pointB, pointC);

//    @org.junit.jupiter.api.Test
//    void inputTriangl () {
//
//        assertEquals(t.toString(), );
//    }

    @org.junit.jupiter.api.Test
    void getPerimetr() {
        assertEquals(t.getPerimetr(), 12);
    }

    @org.junit.jupiter.api.Test
    void getAree() {
        assertEquals(t.getAree(), Math.sqrt(12));
    }

    @org.junit.jupiter.api.Test
    void calculateSides() {
        assertEquals(t.getAB(), 4);
        assertEquals(t.getBC(), 5);
        assertEquals(t.getAC(), 3);
    }
}