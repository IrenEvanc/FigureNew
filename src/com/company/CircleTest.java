package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    ArrayList<Point> points;
    Circle c;

    @BeforeEach
    void setUp() {
        ArrayList<Point> points = new ArrayList<Point>(2);
        Collections.addAll(points, new Point(5, 1), new Point(5, 5));
        this.c = new Circle(points);
    }

    @Test
    void calculateRadius() {
        assertEquals(c.getRadius(), 4);
    }

    @Test
    void calculatePerimetr() {
        assertEquals(c.getPerimetr(), Math.PI * 8);
    }

    @Test
    void calculateArea() {
        assertEquals(c.getArea(), Math.PI * 16);
    }
}
