package com.company;

public class PolygonCreator extends FigureCreator {

    @Override
    public Figure creatFigure () {
        return Polygon.inputPolygon();
    }
}
