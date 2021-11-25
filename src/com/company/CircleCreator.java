package com.company;

public class CircleCreator extends FigureCreator{

    @Override
    public Figure creatFigure () {
        return Circle.inputCircle(2);
    }
}
