package Creator;

import Figures.Figure;
import Figures.Rectangle;
import com.company.Point;

import java.util.ArrayList;

public class RectangleCreator extends FigureCreator {

        @Override
        public Figure create (ArrayList<Point> points) {

            return new Rectangle(points);
        }
}
