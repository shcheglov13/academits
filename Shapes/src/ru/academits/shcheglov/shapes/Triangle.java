package ru.academits.shcheglov.shapes;

public class Triangle implements Shape {
    private double x1;
    private double x2;
    private double x3;
    private double y1;
    private double y2;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    @Override
    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    @Override
    public double getArea() {
        double lineSegmentLength1 = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        double lineSegmentLength2 = Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2));
        double lineSegmentLength3 = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));

        double semiPerimeter = (lineSegmentLength1 + lineSegmentLength2 + lineSegmentLength3) / 2;

        return Math.sqrt(semiPerimeter * (semiPerimeter - lineSegmentLength1) * (semiPerimeter - lineSegmentLength2)
                * (semiPerimeter - lineSegmentLength3));
    }

    @Override
    public double getPerimeter() {
        double lineSegmentLength1 = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        double lineSegmentLength2 = Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2));
        double lineSegmentLength3 = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));

        return lineSegmentLength1 + lineSegmentLength2 + lineSegmentLength3;
    }

    @Override
    public String toString() {
        return "Треугольник:\n" +
                "Ширина - " + getWidth() +
                "\nВысота - " + getHeight() +
                "\nПлощадь - " + getArea() +
                "\nПериметр - " + getPerimeter();
    }
}