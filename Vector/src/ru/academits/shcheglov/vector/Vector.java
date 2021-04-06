package ru.academits.shcheglov.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размер вектора должен быть > 0. Аргумент size = " + size);
        }

        components = new double[size];
    }

    public Vector(int size, double... components) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размер вектора должен быть > 0");
        }

        this.components = Arrays.copyOf(components, size);
    }

    public Vector(Vector vector) {
        components = vector.components.clone();
    }

    public Vector(double... components) {
        if (components.length == 0) {
            throw new IllegalArgumentException("Размер вектора должен быть > 0");
        }

        this.components = Arrays.copyOf(components, components.length);
    }

    public double getComponent(int index) {
        return components[index];
    }

    public void setComponent(int index, double component) {
        components[index] = component;
    }

    public int getSize() {
        return components.length;
    }

    public double getLength() {
        double sum = 0;

        for (double component : components) {
            sum += component * component;
        }

        return Math.sqrt(sum);
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    public void reverse() {
        multiplyByScalar(-1);
    }

    public void add(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] += vector.components[i];
        }
    }

    public void subtract(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] -= vector.components[i];
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Vector v = (Vector) o;

        if (components.length != v.components.length) {
            return false;
        }

        for (int i = 0; i < components.length; i++) {
            if (components[i] != v.components[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int prime = 13;
        int hash = 1;

        hash = hash * prime * Arrays.hashCode(components);

        return hash;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");

        for (int i = 0; i < components.length - 1; i++) {
            stringBuilder.append(components[i]).append(", ");
        }

        stringBuilder.append(components[components.length - 1]).append("}");

        return stringBuilder.toString();
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        int min = Math.min(vector1.components.length, vector2.components.length);
        double sum = 0;

        for (int i = 0; i < min; i++) {
            sum += vector1.components[i] * vector2.components[i];
        }

        return sum;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector newVector = new Vector(vector1);
        newVector.add(vector2);

        return newVector;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector newVector = new Vector(vector1);
        newVector.subtract(vector2);

        return newVector;
    }
}