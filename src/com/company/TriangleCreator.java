package com.company;

public class TriangleCreator extends FigureCreator{

    @Override
    public Figure creatFigure () {
        return Triangle.inputTriangl(3);
    }
}
