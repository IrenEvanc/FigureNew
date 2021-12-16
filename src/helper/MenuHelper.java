//package helper;
//
//import Creator.CircleCreator;
//import Creator.FigureCreator;
//import Creator.RectangleCreator;
//import Creator.TriangleCreator;
//import Figures.Figure;
//import com.company.Point;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.InputMismatchException;
//
//public class MenuHelper {
//    final static String FILENAME = "Figure.txt";
//    private static ArrayList<String> lines;
//    private static Path fileWithFigures;
//    static {
//        fileWithFigures = Paths.get(FILENAME);
//        try {
//            lines = (ArrayList<String>) Files.readAllLines(fileWithFigures);
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public static ArrayList<Figure> getAllFigiresInFile()   {
//        return MenuHelper.getFiguresByFileHelper(lines);
//    }
//    public static ArrayList<Figure> getFiguresByFileHelper(ArrayList<String> lines) {
//        ArrayList<Figure> figures = new ArrayList<>();
//        FigureCreator figureFactory;
//        try {
//            for (String line : lines) {
//                ArrayList<Point> points = receivePoints(line.split(";"));
//                if (points.size()>1) {
//                    figureFactory = getFigureCreator(points);
//                    figures.add(figureFactory.create());
//                }
//            }
//        }
//        catch (InputMismatchException e){
//            e.printStackTrace();
//        }
//        return figures;
//    }
//    private static ArrayList<Point> userPoints(){
//        ArrayList<Point> userPoints = new ArrayList<>();
//        boolean Exit = false;
//        int i =0;
//        while (!Exit){
//            if (i<2){
//                userPoints.add(getUserPoits());
//            }
//            else {
//                System.out.println("Ввести еще одну координату? Y/N");
//                switch (Helper.readString()) {
//                    case "Y":
//                        userPoints.add(getUserPoits());
//                        break;
//                    case "N":
//                        Exit = true;
//                        break;
//                    default:
//                        System.out.println("Введено некорректное значение");
//                        break;
//                }
//            }
//            i++;
//        }
//
//        return userPoints;
//    }
//
//    private static Point getUserPoits() {
//        System.out.println("Введите х: ");
//        double x = Helper.readDouble();
//        System.out.println("Введите y: ");
//        double y = Helper.readDouble();
//        System.out.println("Координата добавлена");
//        return new Point(x,y);
//    }
//    public static Figure getFigureByConsole(){
//        ArrayList <Point> points = userPoints();
//        FigureCreator figureCreator = getFigureCreator(points);
//        return figureCreator.create();
//    }
//
//    private static FigureCreator getFigureCreator(ArrayList <Point> points) {
//        FigureCreator figureCreator;
//        switch (points.size()) {
//            case 2:
//                figureCreator = new CircleCreator();
//                break;
//            case 3:
//                figureCreator = new TriangleCreator();
//                break;
//            case 4:
//                figureCreator = new RectangleCreator();
//                break;
//            default:
////                figureFactory = new PolygonFactory();
//                break;
//        }
//        return figureCreator;
//    }
//
//
//    public static void addFigureInFile(Figure figure){
//        try {
//            lines.add(figure.getPointsToString());
//            Files.write(fileWithFigures, lines);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
