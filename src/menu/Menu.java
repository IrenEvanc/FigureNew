package menu;

import Creator.*;
import Figures.Circle;
import Figures.Figure;
import Figures.Rectangle;
import Figures.Triangle;
import Vizualis.Window;
import com.company.Point;
import helper.Helper;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Menu {
    private String file;
    private ArrayList<Figure> figures;
    private static String Menu = "Выберите нужный пункт меню:\n" +
            "1 - Вывести все фигуры\n" +
            "2 - Добавить фигуру\n" +
            "3 - Изменить фигуру\n" +
            "4 - Удалить фигуру\n" +
            "5 - Перейти в отрисовку\n" +
            "0 - Выход";
    private static String SubMenu = "Выберете действие:\n" +
            "1 - Поворот фигуры\n" +
            "2 - Перемещение фигуры\n" +
            "3 - Масштабирование фигуры\n" +
            "4 - Вернуться в главное меню";

    public Menu (String file, ArrayList<Figure> figures) {
        this.file = file;
        this.figures = figures;
    }

    public static ArrayList<Figure> initialize() {
        ArrayList<Figure> figures = new ArrayList<>();
            ArrayList<Point> triangle1 = new ArrayList<>();
            Collections.addAll(triangle1, new Point(5,5), new Point(5,1), new Point(1,1));
            Triangle t1 = new Triangle(triangle1);
            ArrayList<Point> rectangle = new ArrayList<>();
            Collections.addAll(rectangle, new Point(1,1), new Point(5,1), new Point(5,3), new Point(1,3));
            Rectangle r = new Rectangle(rectangle);
            ArrayList<Point> circle = new ArrayList<>();
            Collections.addAll(circle, new Point(5,5), new Point(5,1));
            Circle c = new Circle(circle);
        Collections.addAll(figures, t1, r, c);
        return figures;
    }

    public static void menu(ArrayList<Figure> figures, String file) {
        while (true) {
            System.out.println(Menu);
            switch (Helper.readInt()) {
                case 1:
                    printFigure(figures);
                        if (figures.size() == 0) {
                            System.out.println("Нет сохраненных фигур!");
                        }
                    break;
                case 2:
                    getFigure(figures);
                    saveToFile(figures, file);
                    System.out.println("Объект сохранен");
                    break;
                case 3:
                    startActionFigureMenu(figures, file);
                    saveToFile(figures, file);
                    break;
                case 4:
                    RemoveFigure (figures);
                    saveToFile(figures, file);
                    break;
                case 5:
                    new Window(figures);
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
    public static Figure getFigure(ArrayList<Figure> figures){
        ArrayList <Point> points = Figure.input();
        FigureCreator figureCreator = selectFigure(points);
        Figure figure = figureCreator.create(points);
        figures.add(figure);
        return figure;
    }

    public static  FigureCreator selectFigure(ArrayList<Point> points) {
        FigureCreator figureCreator;
        switch (points.size()-1) {
            case 1:
                figureCreator = new CircleCreator();
                break;
            case 2:
                figureCreator = new TriangleCreator();
                break;
            case 3:
                figureCreator = new RectangleCreator();
                break;
            default:
                figureCreator = new PolygonCreator();
        }
        return figureCreator;
    }


    private static void RemoveFigure(ArrayList<Figure> figures) {
        int number;
        System.out.println("Доступно фигур: " + figures.size() + ".\nВведите порядковый номер (начиная с 1) удаляемой фигуры");
        number = Helper.readInt(0, figures.size() + 1);
        figures.remove(figures.get(number - 1));

    }

    private static void startActionFigureMenu(ArrayList<Figure> figures, String file) {
        int number;
        System.out.println("Доступно фигур: " + figures.size() + ".\nВведите порядковый номер (начиная с 1) для вывода желаемой фигуры");
        number = Helper.readInt(0, figures.size() + 1);
        Figure figure = figures.get(number - 1);
//        System.out.println(figure.getName() + "\n" + figure.toString()); /вывод нужной фигуры
        actionFigure(figure, figures, file);
    }

    private static void actionFigure(Figure figure, ArrayList<Figure> figures, String file) {
        boolean isAction = true;
        Figure f = figure;
        while (isAction) {
            System.out.println(SubMenu);
            switch (Helper.readInt()) {
                case 1:
                    rotateFigure(f);
                    saveFigure(figures, file);
                    break;
                case 2:
                    moveFigure(f);
                    saveFigure( figures, file);
                    break;
                case 3:
                    scaleFigure(f);
                    saveFigure( figures, file);
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

        private static void saveFigure(ArrayList<Figure> figures, String file){
        boolean flag = true;
        while (flag) {
            System.out.println("Выберете действие:\n1 - Сохранить\n2 - Отмена");
            switch (Helper.readInt()) {
                case 1:
                    saveToFile(figures,file);
                    System.out.println("Объект сохранен");
                    flag = false;
                    break;
                case 2:
                    flag = false;
                    break;
                default:
                    System.out.println("Введено некорректное значение");
                    break;
            }
        }
    }

    public static void saveToFile(ArrayList<Figure> figures, String file){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, false));
            oos.writeObject(figures);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Figure> initFromFile(String file){
        ArrayList<Figure> figures = new ArrayList<Figure>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            figures = (ArrayList<Figure>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return figures;
    }
}
