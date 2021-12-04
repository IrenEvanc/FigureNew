package Creator;

import Figures.Circle;
import Figures.Figure;

public class CircleCreator extends FigureCreator {

    @Override
    public Figure create () {
        return new Circle(Figure.input(2));
    }
}
