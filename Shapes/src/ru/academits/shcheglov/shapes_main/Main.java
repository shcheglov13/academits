package ru.academits.shcheglov.shapes_main;

import ru.academits.shcheglov.shapes.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(4),
                new Rectangle(10.1, 5),
                new Triangle(1, 1, 5, 1, 3, 4),
                new Square(5),
                new Rectangle(4, 7)
        };

        Shape shapeWithMaxArea = getShapeWithMaxArea(shapes);
        Shape shapeWithPenultimatePerimeter = getShapeWithPenultimatePerimeter(shapes);

        System.out.println(shapeWithMaxArea);
        System.out.println("Площадь фигуры: " + shapeWithMaxArea.getArea());

        System.out.println();

        System.out.println(shapeWithPenultimatePerimeter);
        System.out.println("Периметр фигуры: " + shapeWithPenultimatePerimeter.getPerimeter());
    }

    public static Shape getShapeWithMaxArea(Shape... shapes) {
        if (shapes.length == 0) {
            throw new IndexOutOfBoundsException("В метод передан пустой массив фигур");
        }

        Arrays.sort(shapes, new AreaComparator());
        return shapes[shapes.length - 1];
    }

    public static Shape getShapeWithPenultimatePerimeter(Shape... shapes) {
        if (shapes.length == 0 || shapes.length == 1) {
            throw new IndexOutOfBoundsException("В массиве слишком мало фигур");
        }

        Arrays.sort(shapes, new PerimeterComparator());
        return shapes[shapes.length - 2];
    }
}