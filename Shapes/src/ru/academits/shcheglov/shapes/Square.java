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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Square s = (Square) o;

        return sideLength == s.sideLength;
    }

    @Override
    public int hashCode() {
        int prime = 13;
        int hash = 1;

        return prime * hash + Double.hashCode(sideLength);
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