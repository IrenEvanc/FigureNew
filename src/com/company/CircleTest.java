package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    Point center = new Point(1,1);
    double radius = 5;
    Circle c = new Circle(center, radius);

//    @Test
//    void inputCircle() {
//        assertEquals(Circle.inputCircle(), c);
//    }

    @Test
    void getPerimetr() {
        assertEquals(c.getPerimetr(), Math.PI*10);
    }

    @Test
    void getAree() {
        assertEquals(c.getAree(), Math.PI*25);
    }
}