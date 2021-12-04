package Creator;

import Figures.Figure;
import Figures.Triangle;

public class TriangleCreator extends FigureCreator {

    @Override
    public Figure create () {

        return new Triangle(Figure.input(3));
    }
}
