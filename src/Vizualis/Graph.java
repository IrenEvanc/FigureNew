package Vizualis;

import Figures.Circle;
import Figures.Figure;
import com.company.Point;
import java.awt.*;
import java.util.ArrayList;

public class Graph extends Canvas {
    public ArrayList<Figure> figures;
    private Graphics2D canvas;
    public int multiplier;

    public Graph (ArrayList<Figure> figures){
        super();
        this.figures = figures;
    }

    public void paint (Graphics g) {
        g.setClip(0, 0, this.getWidth(), this.getHeight());
        canvas = (Graphics2D)g.create(0, 0, this.getWidth() , this.getHeight());
        //Graphics canvas = g.create(0, 0, this.getWidth() , this.getHeight());
        canvas.setColor(Color.WHITE);
        canvas.fillRect(0, 0, this.getWidth(), this.getHeight());
        canvas.setColor(Color.GRAY);
        canvas.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
        canvas.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
        canvas.setColor(Color.GREEN);
        //Graphics2D graphics2D = (Graphics2D)(canvas.create(0, 0, this.getWidth(), this.getHeight()));
        canvas.setStroke(new BasicStroke(3.0F));

        if (figures.size() > 0) {
            double minX = (int) figures.get(0).getPoints().get(0).getX();
            double minY = (int) figures.get(0).getPoints().get(0).getY();
            double maxX = (int) figures.get(0).getPoints().get(0).getX();
            double maxY = (int) figures.get(0).getPoints().get(0).getY();

            for (Figure f : figures) {
                if (f instanceof Circle) {
                    if (f.getCenter().getX() - ((Circle) f).getRadius() < minX) minX = f.getCenter().getX() - ((Circle) f).getRadius();
                    if (f.getCenter().getX() + ((Circle) f).getRadius() > maxX) maxX = f.getCenter().getX() + ((Circle) f).getRadius();
                    if (f.getCenter().getY() - ((Circle) f).getRadius() < minY) minY = f.getCenter().getY() - ((Circle) f).getRadius();
                    if (f.getCenter().getY() + ((Circle) f).getRadius() > maxY) maxY = f.getCenter().getY() + ((Circle) f).getRadius();
                } else {
                    for (Point point : f.getPoints()) {
                        if (point.getX() < minX) minX = point.getX();
                        if (point.getX() > maxX) maxX = point.getX();
                        if (point.getY() < minY) minY = point.getY();
                        if (point.getY() > maxY) maxY = point.getY();
                    }
                }
            }
            int multiplierX = (int) (this.getWidth() * 0.5 / Math.max (Math.abs(minX), Math.abs(maxX)));
            int multiplierY = (int) (this.getHeight() * 0.5 / Math.max (Math.abs(minY), Math.abs(maxY)));
            multiplier = Math.min(multiplierX, multiplierY);
            for (Figure figure : figures) {
                drawFigures(g, figure);
            }
        }
    }

    public void drawFigures(Graphics g, Figure figure){
        ArrayList<Point> points = figure.getPoints();
        if (figure instanceof Circle) {
            Circle circle = (Circle) figure;
            int x1 = (int) (circle.getCenter().getX() * multiplier) + getWidth() / 2;
            int y1 = -(int) (circle.getCenter().getY() * multiplier) + getHeight() / 2;
            int radius = (int) circle.getRadius() * multiplier;
            canvas.drawOval(x1 - radius, y1 - radius, radius * 2, radius * 2);
        } else {
            for (int i = 0; i < points.size() - 1; i++) {
                int x1 = (int) (points.get(i).getX() * multiplier) + getWidth() / 2;
                int y1 = -(int) (points.get(i).getY() * multiplier) + getHeight() / 2;
                int x2 = (int) (points.get(i + 1).getX() * multiplier) + getWidth() / 2;
                int y2 = -(int) (points.get(i + 1).getY() * multiplier) + getHeight() / 2;
                canvas.drawLine(x1, y1, x2, y2);
            }
            int x1 = (int) (points.get(points.size() - 1).getX() * multiplier) + getWidth() / 2;
            int y1 = -(int) (points.get(points.size() - 1).getY() * multiplier) + getHeight() / 2;
            int x2 = (int) (points.get(0).getX() * multiplier) + getWidth() / 2;
            int y2 = -(int) (points.get(0).getY() * multiplier) + getHeight() / 2;
            canvas.drawLine(x1, y1, x2, y2);
        }
    }

    public void repaintGraph (ArrayList<Figure> figures){
        this.figures = figures;
        this.repaint();
    }

}
