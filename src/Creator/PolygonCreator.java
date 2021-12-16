package Creator;

import Figures.Figure;
import Figures.Polygon;
import com.company.Point;

import java.util.ArrayList;

public class PolygonCreator extends FigureCreator {

    @Override
    public Figure create (ArrayList<Point> points) {

        return new Polygon(points);
    }
}
