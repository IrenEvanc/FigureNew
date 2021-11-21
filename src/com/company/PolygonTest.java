package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolygonTest {
    Point pointA = new Point(0,5);
    Point pointB = new Point(4, 0);
    Polygon p = new Polygon(pointA, pointB);

//    @Test
//    void inputPolygon() {
//
//    }

    @Test
    void getPerimetr() {
        assertEquals(p.getPerimetr(), 9);
    }

    @Test
    void getAree() {
        assertEquals(p.getAree(), 20);
    }
}