package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Point> triangle = new ArrayList<>();
        Collections.addAll(triangle, new Point(3,2), new Point(5,1), new Point(1,1));
        Triangle t = new Triangle(triangle);
        ArrayList<Point> triangle1 = new ArrayList<>();
        Collections.addAll(triangle1, new Point(5,5), new Point(5,1), new Point(1,1));
        Triangle t1 = new Triangle(triangle1);
        ArrayList<Point> rectangle = new ArrayList<>();
        Collections.addAll(rectangle, new Point(5,5), new Point(5,1), new Point(1,1), new Point(1,5));
        Rectangle r = new Rectangle(rectangle);
        ArrayList<Point> circle = new ArrayList<>();
        Collections.addAll(rectangle, new Point(5,5), new Point(5,1));
        Circle c = new Circle(circle);

        ArrayList<Figure> figures = new ArrayList<>();
        Collections.addAll(figures, t, t1, r, c);
        menu(figures);
    }

    public static void menu(ArrayList<Figure> figures) {
        Scanner in = new Scanner(System.in);
        while (true) {
        System.out.println("Выберите нужный пункт меню");
        System.out.println("1. Вывести все фигуры");
        System.out.println("2. Добавить фигуры");
        System.out.println("3. Изменить фигуры");
        System.out.println("4. Удалить фигуру");
        System.out.println("0. Выход");

            int num = in.nextInt();
            switch (num) {
                case 1:
                    printFigure(figures);
                    break;
                case 2:
                    System.out.println("Какую фигуру хотите создать?");
                    FigureCreator figureCreator;
                    figureCreator = selectFigure();
                    Figure figure = figureCreator.creatFigure();
                    figures.add(figure);
                    break;
//                case 3:
//                    System.out.println("Выберите фигуру, которую нужно изменить");
//                    num = in.nextInt();
//                    FigureCreator changeFigure;
//                    changeFigure = changeFigure ();
//                    figures.add(figure);
//                    break;

                case 4:
                    printFigure(figures);
                    System.out.println("Выберите фигуру, которую вы хотите удалить");
                    num = in.nextInt();
                    figures.remove(num - 1);
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
    static void printFigure (ArrayList<Figure> figures) {
        int i=1;
        for (Figure f: figures) {
            System.out.println(i+". "+f);
            i++;
        }
    }

    static  FigureCreator selectFigure() {
        System.out.println("Выберите, какую фигуру вы хотите создать");
        System.out.println("1. Треугольник");
        System.out.println("2. Круг");
        System.out.println("3. Прямоугольник");
        FigureCreator selectCreator;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        switch (n) {
            case 1:
                selectCreator = new TriangleCreator();
                break;
            case 2:
                figureCreator = new CircleCreator();
                break;
            case 3:
                figureCreator = new RectangleCreator();
                break;
            default:
                System.out.println("Введите правильное значение");
                return selectFigure();
        }
        return figureCreator;
    }

}

