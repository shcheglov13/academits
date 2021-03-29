package ru.academits.shcheglov.vector_main;

import ru.academits.shcheglov.vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[] array1 = {1.1, 2, 3.7, 4};
        double[] array2 = {2, 5, 6.3};

        Vector vector1 = new Vector(array1);
        Vector vector2 = new Vector(5, array2);
        Vector vector3 = new Vector(vector1);
        Vector vector4 = new Vector(2);

        System.out.println("Сравнение на равенство векторов: " + vector1.equals(vector3));
        System.out.println("Сравнение на равенство hashCode векторов: " + (vector1.hashCode() == vector3.hashCode()));

        double size = vector1.getSize();
        System.out.println("Размер вектора: " + size);

        double length = vector1.getLength();
        System.out.println("Длина вектора: " + length);

        vector1.add(vector2);
        System.out.println("Результат сложения: " + vector1);

        vector1.subtract(vector2);
        System.out.println("Результат разности: " + vector1);

        vector3.multiplyByScalar(5);
        System.out.println("Результат умножения на скаляр: " + vector3);

        vector3.reverse();
        System.out.println("Развернутый вектор: " + vector3);

        Vector vector5 = Vector.getVectorsSum(vector3, vector1);
        System.out.println("Результат суммы векторов через статический метод: " + vector5);

        Vector vector6 = Vector.getVectorsDifference(vector1, vector5);
        System.out.println("Результат разности векторов через статический метод: " + vector6);

        double scalar = Vector.getVectorsScalarMultiplication(vector6, vector4);
        System.out.println("Результат скалярного произведения векторов через статический метод: " + scalar);
    }
}