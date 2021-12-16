package Creator;

import Figures.Figure;
import Figures.Triangle;
import com.company.Point;

import java.util.ArrayList;

public class TriangleCreator extends FigureCreator {

    @Override
    public Figure create (ArrayList<Point> points) {

        return new Triangle(points);
    }
}
