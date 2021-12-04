package Creator;

import Figures.Figure;
import Figures.Rectangle;

public class RectangleCreator extends FigureCreator {

        @Override
        public Figure create () {

            return new Rectangle(Figure.input(4));
        }
}
