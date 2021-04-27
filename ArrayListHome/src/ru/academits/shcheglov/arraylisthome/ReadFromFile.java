package ru.academits.shcheglov.arraylisthome;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFromFile {
    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileInputStream("ArrayListHome/src/ru/academits/shcheglov/arraylisthome/input.txt"))) {
            ArrayList<String> stringsList = new ArrayList<>();

            while (scanner.hasNextLine()) {
                stringsList.add(scanner.nextLine());
            }

            System.out.println(stringsList);
        }
    }
}