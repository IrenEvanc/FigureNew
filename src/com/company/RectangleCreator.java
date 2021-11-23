package com.company;

public class RectangleCreator extends FigureCreator{

        @Override
        public Figure creatFigure () {
            return Rectangle.inputRectangle();
        }
    }

