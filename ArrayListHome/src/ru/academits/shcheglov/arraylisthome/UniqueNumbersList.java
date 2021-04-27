package ru.academits.shcheglov.arraylisthome;

import java.util.ArrayList;
import java.util.Arrays;

public class UniqueNumbersList {
    public static void main(String[] args) {
        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 13, 7, 8, 9, 13, 6, 1, 7, 9, 6));
        ArrayList<Integer> uniqueNumbersList = new ArrayList<>();

        for (Integer number1 : numbersList) {
            boolean isUnique = true;

            for (Integer number2 : uniqueNumbersList)
                if (number1.equals(number2)) {
                    isUnique = false;
                    break;
                }

            if (isUnique) {
                uniqueNumbersList.add(number1);
            }
        }

        System.out.println(uniqueNumbersList);
    }
}