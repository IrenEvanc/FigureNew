package Vizualis;

import Figures.Circle;
import Figures.Figure;
import com.company.Point;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Graph extends Canvas {
    public ArrayList<Figure> figures;
    public int multiplierX, multiplierY;
    public double minX, minY;

    public Graph (ArrayList<Figure> figures){
        super();
        this.figures = figures;
    }

    public void paint (Graphics g) {
        int width = this.getWidth();
        int height = this.getHeight();
        int startX = 0;
        int startY = 0;
        Graphics canvas = g.create(startX, startY, width, height);
        canvas.setColor(Color.pink.brighter());
        canvas.fillRect(0, 0, width, height);
        canvas.setColor(Color.BLACK);
        canvas.drawLine(width / 2, 0, width / 2, height);
        canvas.drawLine(0, height / 2, width, height / 2);

        if (figures.size() > 0) {
             minX = figures.get(0).getPoints().get(0).getX();
             minY = figures.get(0).getPoints().get(0).getY();
            double maxX = figures.get(0).getPoints().get(0).getX();
            double maxY = figures.get(0).getPoints().get(0).getY();
            for (Figure f : figures) {
                if (f instanceof Circle) {
                    if ((f.getCenter().getX()-((Circle) f).getRadius()) < minX) minX = f.getCenter().getX()-((Circle) f).getRadius();
                    if ((f.getCenter().getY()-((Circle) f).getRadius()) < minY) minY = f.getCenter().getY()-((Circle) f).getRadius();
                    if ((f.getCenter().getX()+((Circle) f).getRadius()) > maxX) maxX = f.getCenter().getX()+((Circle) f).getRadius();
                    if ((f.getCenter().getY()+((Circle) f).getRadius()) > maxY) maxY = f.getCenter().getY()+((Circle) f).getRadius();

                }
                else for (Point point : f.getPoints()) {
                    if (point.getX() < minX) minX = point.getX();
                    if (point.getY() < minY) minY = point.getY();
                    if (point.getX() > maxX) maxX = point.getX();
                    if (point.getY() > maxY) maxY = point.getY();
                }
            }
            multiplierX = (int) (width * 0.5 / Math.max (Math.abs(maxX), Math.abs(minX)));
            multiplierY = (int) (height * 0.5 / Math.max (Math.abs(maxY), Math.abs(minY)));
            for (Figure figure : figures) {
                drawFigures(g, figure, multiplierX, multiplierY);
            }
        }
    }
    public void drawFigures (Graphics g, Figure figure, int multiplierX, int multiplierY) {

//        for (Figure figure : figures) {
            if (figure instanceof Circle) {
                Circle c = (Circle) figure;
                int multiplier = Math.min (multiplierX, multiplierY);
                int radius = (int) c.getRadius()*multiplier;
                int x1 = (int) (c.getCenter().getX()*multiplierX);
                int y1 =  (int) (c.getCenter().getY()*multiplierY);
                g.drawOval(x1-radius, y1-radius,
                        radius*2, radius*2);
            }
            else {
                for (int i=0; i<figure.getPoints().size()-1; i++) {
                    g.drawLine((int) figure.getPoints().get(i).getX()*multiplierX, (int) figure.getPoints().get(i).getY()*multiplierY,
                            (int) figure.getPoints().get(i+1).getX()*multiplierX, (int) figure.getPoints().get(i+1).getY()*multiplierY);
                }
                g.drawLine((int) figure.getPoints().get(0).getX()*multiplierX, (int) figure.getPoints().get(0).getY()*multiplierY,
                        (int) figure.getPoints().get(figure.getPoints().size()-1).getX()*multiplierX, (int) figure.getPoints().get(figure.getPoints().size()-1).getY()*multiplierY);
            }

    }
    public void repaintGraph (ArrayList<Figure> figures){
        this.figures = figures;
        this.repaint();
    }

}
