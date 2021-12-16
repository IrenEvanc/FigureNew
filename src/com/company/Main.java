package com.company;

import Figures.Figure;
import Vizualis.Window;
import menu.Menu;

import java.util.ArrayList;

import static menu.Menu.*;

public class Main {

    public final static String file = "Figure.txt";

    public static void main(String[] args) {
        ArrayList<Figure> figures = Menu.initFromFile (file);
            if (figures.size() == 0) {
            figures = Menu.initialize();
            Menu.saveToFile(figures, file);
            }
//        new Window(figures);
        menu(figures, file);
    }
}

