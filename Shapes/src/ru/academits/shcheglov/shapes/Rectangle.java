package ru.academits.shcheglov.shapes;

public class Rectangle implements Shape {
    private double sideLength1;
    private double sideLength2;

    public Rectangle(double sideLength1, double sideLength2) {
        this.sideLength1 = sideLength1;
        this.sideLength2 = sideLength2;
    }

    @Override
    public double getWidth() {
        return Math.min(sideLength1, sideLength2);
    }

    @Override
    public double getHeight() {
        return Math.max(sideLength1, sideLength2);
    }

    @Override
    public double getArea() {
        return sideLength1 * sideLength2;
    }

    @Override
    public double getPerimeter() {
        return (sideLength1 + sideLength2) * 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Rectangle r = (Rectangle) o;

        return sideLength1 == r.sideLength1 && sideLength2 == r.sideLength2;
    }

    @Override
    public int hashCode() {
        int prime = 13;
        int hash = 1;

        hash = prime * hash + Double.hashCode(sideLength1);
        hash = prime * hash + Double.hashCode(sideLength2);

        return hash;
    }

    @Override
    public String toString() {
        return "Прямоугольник:\n" +
                "Ширина - " + getWidth() +
                "\nВысота - " + getHeight() +
                "\nПлощадь - " + getArea() +
                "\nПериметр - " + getPerimeter();
    }
}