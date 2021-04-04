package ru.academits.shcheglov.matrix;

import java.util.Arrays;

import ru.academits.shcheglov.vector.Vector;

public class Matrix {
    private Vector[] rows;

    public Matrix(int rowsCount, int columnsCount) {
        if (rowsCount <= 0) {
            throw new IllegalArgumentException("Некорректная матрица. Количество строк должно быть больше 0");
        }

        rows = new Vector[rowsCount];

        Arrays.fill(rows, new Vector(columnsCount));
    }

    public Matrix(Matrix matrix) {
        rows = matrix.rows.clone();
    }

    public Matrix(double[]... array) {
        rows = new Vector[array.length];

        if (rows.length == 0) {
            throw new IllegalArgumentException("Некорректная матрица. Количество строк должно быть больше 0");
        }

        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Vector(array[i]);
        }
    }

    public Matrix(Vector... rows) {
        this.rows = new Vector[rows.length];

        if (rows.length == 0) {
            throw new IllegalArgumentException("Некорректная матрица. Количество строк должно быть больше 0");
        }

        System.arraycopy(rows, 0, this.rows, 0, this.rows.length);
    }

    public int getRowsCount() {
        return rows.length;
    }

    public int getColumnsCount() {
        return rows[0].getSize();
    }

    public Vector getRow(int index) {
        return rows[index];
    }

    public void setRow(int index, Vector vector) {
        rows[index] = vector;
    }

    public Vector getColumn(int index) {
        Vector column = new Vector(rows.length);

        for (int i = 0; i < rows.length; i++) {
            column.setComponent(i, rows[i].getComponent(index));
        }

        return column;
    }

    public void transpose() {
        Vector[] newRows = new Vector[getColumnsCount()];

        for (int i = 0; i < getColumnsCount(); i++) {
            newRows[i] = getColumn(i);
        }

        rows = newRows;
    }

    public void multiplyByScalar(double scalar) {
        for (Vector row : rows) {
            row.multiplyByScalar(scalar);
        }
    }

    public void multiplyByVector(Vector vector) {
        if (vector.getSize() != getColumnsCount()) {
            throw new IllegalArgumentException();
        }

        Vector[] newRows = new Vector[getRowsCount()];

        for (int i = 0; i < getRowsCount(); i++) {
            for (int j = 0; j < getRowsCount(); j++)
            rows[i] = new Vector(rows[i].getComponent(0) * vector.getComponent(i),
                    rows[i].getComponent(0) * vector.getComponent(i),
                    rows[i].getComponent(0) * vector.getComponent(i));
        }

        rows = newRows;
    }

    public void add(Matrix matrix) {
        if (getRowsCount() != matrix.getRowsCount() || getColumnsCount() != matrix.getColumnsCount()) {
            throw new IllegalArgumentException("Матрицы должны быть одинакового размера");
        }

        for (int i = 0; i < rows.length; i++) {
            rows[i].add(matrix.rows[i]);
        }
    }

    public void subtract(Matrix matrix) {
        if (getRowsCount() != matrix.getRowsCount() || getColumnsCount() != matrix.getColumnsCount()) {
            throw new IllegalArgumentException("Матрицы должны быть одинакового размера");
        }

        for (int i = 0; i < rows.length; i++) {
            rows[i].subtract(matrix.rows[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");

        for (int i = 0; i < rows.length - 1; i++) {
            stringBuilder.append(rows[i]).append("\n");
        }

        stringBuilder.append(rows[rows.length - 1]).append("}");

        return stringBuilder.toString();
    }
}