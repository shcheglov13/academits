package ru.academits.shcheglov.shapes_main;

import ru.academits.shcheglov.shapes.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape shapeWithMaxArea = getShapeWithMaxArea(new Circle(4), new Rectangle(10, 5),
                new Triangle(1, 1, 5, 1, 3, 4), new Square(5), new Rectangle(4, 7));

        Shape shapeWithPenultimatePerimeter = getShapeWithPenultimatePerimeter(new Circle(4), new Rectangle(10, 5),
                new Triangle(1, 1, 5, 1, 3, 4), new Square(5), new Rectangle(4, 7));

        System.out.println(shapeWithMaxArea);
        System.out.println();
        System.out.println(shapeWithPenultimatePerimeter);
    }

    public static Shape getShapeWithMaxArea(Shape... shapes) {
        AreaComparator areaComparator = new AreaComparator();

        Arrays.sort(shapes, areaComparator);
        return shapes[shapes.length - 1];
    }

    public static Shape getShapeWithPenultimatePerimeter(Shape... shapes) {
        PerimeterComparator perimeterComparator = new PerimeterComparator();

        Arrays.sort(shapes, perimeterComparator);
        return shapes[shapes.length - 2];
    }
}