package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class PolygonTest {

    ArrayList <Point> points;
    Rectangle r;

    @BeforeEach
     void setUp() {
        ArrayList <Point> points = new ArrayList<Point>(4);
        Collections.addAll(points, new Point(5, 1), new Point(5, 3), new Point(10, 3), new Point(10, 1));
        this.r = new Rectangle(points);
    }

    @Test
    void calculateCenter() {
        assertEquals(r.getCenter(), new Point(7.5, 2));
    }

    @Test
    void calculatePerimetr() {
        assertEquals(r.getPerimetr(), 14);
    }

    @Test
    void calculateArea() {
        assertEquals(r.getArea(), 10);
    }
}