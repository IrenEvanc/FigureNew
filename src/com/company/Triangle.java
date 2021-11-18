package com.company;

public class Triangle extends Figure implements IMovable{
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private double AB;
    private double BC;
    private double AC;

    public Triangle(Point pointA, Point pointB, Point pointC){
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.calculateSides();
    }
    private void calculateSides () {
        this.AB = Math.sqrt(Math.pow(pointA.x - pointB.x, 2) + Math.pow(pointA.y - pointB.y, 2));
        this.BC = Math.sqrt(Math.pow(pointB.x - pointC.x, 2) + Math.pow(pointB.y - pointC.y, 2));
        this.AC = Math.sqrt(Math.pow(pointA.x - pointC.x, 2) + Math.pow(pointA.y - pointC.y, 2));
    }
    public double getPerimetr () {
        double perimetr = AB + BC + AC;
        return  perimetr;
    }
    public double getAree () {
        double halfPerimetr = getPerimetr()/2;
        double aree = Math.sqrt(halfPerimetr+(halfPerimetr-AB)+(halfPerimetr-BC)+(halfPerimetr-BC));
        return aree;
    }

    @Override
    public String toString () {
        String result = "Треугольник с вершинами в точках: A" + pointA + ", B" + pointB + ", C" + pointC + "\n " +
                "со следующими характеристиками: \n" + "периметр = " + getPerimetr() + ", \n" + "площадь = " + getAree()+ "\n ";
        return result;
    }
    @Override
    public void move(){
        System.out.println("двигаюсь");
    }
}
