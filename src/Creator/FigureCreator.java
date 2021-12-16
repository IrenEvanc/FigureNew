package Creator;

import Figures.Figure;
import com.company.Point;

import java.util.ArrayList;

public abstract class FigureCreator {


    public abstract Figure create(ArrayList<Point> points);

}
