package ru.academits.shcheglov.arraylisthome;

import java.util.ArrayList;
import java.util.Arrays;

public class DeleteEvenNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 18));

        for (int i = 0; i < numbersList.size(); i++) {
            if (numbersList.get(i) % 2 == 0) {
                numbersList.remove(i);
            }
        }

        System.out.println(numbersList);
    }
}