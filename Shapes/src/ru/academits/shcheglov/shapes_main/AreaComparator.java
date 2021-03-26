package ru.academits.shcheglov.shapes_main;

import ru.academits.shcheglov.shapes.Shape;

import java.util.Comparator;

public class AreaComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape s1, Shape s2) {
        return Double.compare(s1.getArea(), s2.getArea());
    }
}