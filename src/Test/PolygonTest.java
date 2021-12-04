package Test;

import com.company.Point;
import Figures.Rectangle;
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
        Collections.addAll(points, new Point(1, 1), new Point(5, 1), new Point(5, 3), new Point(1, 3));
        this.r = new Rectangle(points);
    }

    @Test
    void calculateCenter() {
        assertEquals(r.getCenter(), new Point(3, 2));
    }

    @Test
    void calculatePerimetr() {
        assertEquals(r.getPerimetr(), 12);
    }

    @Test
    void calculateArea() {
        assertEquals(r.getArea(), 8);
    }

}