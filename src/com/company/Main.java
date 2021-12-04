package com.company;

import Creator.CircleCreator;
import Creator.FigureCreator;
import Creator.RectangleCreator;
import Creator.TriangleCreator;
import Figures.Circle;
import Figures.Figure;
import Figures.Rectangle;
import Figures.Triangle;
import helper.Helper;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
//    public Main (){
//        ObjectOutputStream (OutputStream out);
//    }
private static String Menu = "Выберите нужный пункт меню:\n" +
        "1 - Вывести все фигуры\n" +
        "2 - Добавить фигуры\n" +
        "3 - Изменить фигуры\n" +
        "4 - Удалить фигуру\n" +
        "0 - Выход";
    private static String SubMenu = "Выберете действие:\n" +
            "1 - Поворот фигуры\n" +
            "2 - Перемещение фигуры\n" +
            "3 - Масштабирование фигуры\n" +
            "4 - Вернуться в главное меню";

    public static void main(String[] args) {
        ArrayList<Point> triangle = new ArrayList<>();
        Collections.addAll(triangle, new Point(3,2), new Point(5,1), new Point(1,1));
        Triangle t = new Triangle(triangle);
        ArrayList<Point> triangle1 = new ArrayList<>();
        Collections.addAll(triangle1, new Point(5,5), new Point(5,1), new Point(1,1));
        Triangle t1 = new Triangle(triangle1);
        ArrayList<Point> rectangle = new ArrayList<>();
        Collections.addAll(rectangle, new Point(1,1), new Point(5,1), new Point(5,3), new Point(1,3));
        Rectangle r = new Rectangle(rectangle);
        ArrayList<Point> circle = new ArrayList<>();
        Collections.addAll(circle, new Point(5,5), new Point(5,1));
        Circle c = new Circle(circle);

        ArrayList<Figure> figures = new ArrayList<>();
        Collections.addAll(figures, t, t1, r, c);
        menu(figures);
    }

    public static void menu(ArrayList<Figure> figures) {
        while (true) {
            System.out.println(Menu);

            switch (Helper.readInt()) {
                case 1:
                    printFigure(figures);
                    break;
                case 2:
                    System.out.println("Какую фигуру хотите создать?");
                    FigureCreator figureCreator;
                    figureCreator = selectFigure();
                    Figure figure = figureCreator.create();
                    figures.add(figure);
                    break;
                case 3:
                startActionFigureMenu(figures);

                    break;

                case 4:
                    RemoveFigure (figures);
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
            System.out.println(i+". "+ f.getName()+f);
            i++;
        }
    }

    static  FigureCreator selectFigure() {
        System.out.println("Выберите, какую фигуру вы хотите создать");
        System.out.println("1. Треугольник");
        System.out.println("2. Круг");
        System.out.println("3. Прямоугольник");
        FigureCreator figureCreator;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        switch (n) {
            case 1:
                figureCreator = new TriangleCreator();
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
    private static void RemoveFigure(ArrayList<Figure> figures) {
        int number;
        System.out.println("Доступно фигур: " + figures.size() + ".\nВведите порядковый номер (начиная с 1) удаляемой фигуры");
        number = Helper.readInt(0, figures.size() + 1);
        figures.remove(figures.get(number - 1));

    }
    private static void startActionFigureMenu(ArrayList<Figure> figures) {
        int number;
        System.out.println("Доступно фигур: " + figures.size() + ".\nВведите порядковый номер (начиная с 1) для вывода желаемой фигуры");
        number = Helper.readInt(0, figures.size() + 1);
        Figure figure = figures.get(number - 1);
//        System.out.println(figure.getName() + "\n" + figure.toString()); /вывод нужной фигуры
        actionFigure(figure, figures);
    }
    private static void actionFigure(Figure figure, ArrayList<Figure> figures) {
        boolean isAction = true;
        Figure f = figure;
        while (isAction) {
            System.out.println(SubMenu);
            switch (Helper.readInt()) {
                case 1:
                    rotateFigure(f);
//                    saveFigure(figure,f, figures);
                    break;
                case 2:
                    moveFigure(f);
//                    saveFigure(figure,f, figures);
                    break;
                case 3:
                    scaleFigure(f);

//                    saveFigure(figure,f, figures);
                    break;
                case 4:
                    isAction = false;
                    break;
                default:
                    System.out.println("Введено некорректное значение");
                    break;
            }

        }
    }

    private static void scaleFigure(Figure f) {
        System.out.println("Введите параметр масштабирования в формате #.## \n" +
                "(от 0 до 1 - для уменьшения, больше 1 - для увеличения)");
        double scale = Helper.readDouble(0);
        f.scale(scale);
        System.out.println(f.getName() + " после масштабирования\n" + f.toString()); //вывод нужной фигуры
    }

    private static void moveFigure(Figure f) {
        System.out.println("Введите дистанцию на которую передвинуть по горизонтали");
        int x = Helper.readInt();
        System.out.println("Введите дистанцию на которую передвинуть по вертикали");
        int y = Helper.readInt();
        Point vect = new Point(x, y);
        f.move(vect);
        System.out.println(f.getName() + " после перемещения\n" + f.toString()); //вывод нужной фигуры
    }

    private static void rotateFigure(Figure f) {
        System.out.println("Введите градусы в формате #.##");
        double angle = Helper.readDouble();
        f.rotate(angle);
        System.out.println(f.getName() + " после поворота\n" + f.toString()); //вывод нужной фигуры
    }
//    private static void saveFigure(Figure figure, Figure f, ArrayList<Figure> figures){
//        boolean isContinue = true;
//        while (isContinue) {
//            System.out.println("Выберете действие:\n1 - Сохранить\n2 - Отмена");
//            switch (Helper.readInt()) {
//                case 1:
//                    figures.add(figure);
//                    //                    FileHelper.replaceFigureInFile(figure, t);
//                    isContinue = false;
//                    break;
//                case 2:
//                    isContinue = false;
//                    break;
//                default:
//                    System.out.println("Введено некорректное значение");
//                    break;
//            }
//
//        }
//    public static Figure createCopyFigure(Figure figure){
//        ArrayList<Point> copyPoints = new ArrayList<>();
//        for (int i = 0; i < figure.getPoints().size(); i++) {
//            copyPoints.add(new Point(figure.getPoints().get(i).getX(),figure.getPoints().get(i).getY()));
//        }
//        FigureCreator figureFactory = selectFigure();
//        return figureFactory.create();
//    }
}

