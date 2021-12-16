package Creator;

import Figures.Circle;
import Figures.Figure;
import com.company.Point;

import java.util.ArrayList;

public class CircleCreator extends FigureCreator {


    @Override
    public Figure create (ArrayList<Point> points) {
        return new Circle(points);
    }
}
