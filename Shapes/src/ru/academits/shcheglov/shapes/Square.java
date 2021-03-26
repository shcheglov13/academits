package ru.academits.shcheglov.shapes;

public class Square implements Shape {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return 4 * sideLength;
    }

    @Override
    public String toString() {
        return "Квадрат:\n" +
                "Ширина - " + getWidth() +
                "\nВысота - " + getHeight() +
                "\nПлощадь - " + getArea() +
                "\nПериметр - " + getPerimeter();
    }
}