package ru.academits.shcheglov.range_main;

import ru.academits.shcheglov.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начало числового интервала #1:");
        double from1 = scanner.nextDouble();

        System.out.println("Введите конец числового интервала #1:");
        double to1 = scanner.nextDouble();

        System.out.println("Введите начало числового интервала #2:");
        double from2 = scanner.nextDouble();

        System.out.println("Введите конец числового интервала #2:");
        double to2 = scanner.nextDouble();

        Range range1 = new Range(from1, to1);
        Range range2 = new Range(from2, to2);

        for (; ; ) {
            System.out.println("Выберете команду (1-8):");
            System.out.println("\t1. Узнать длину числового интервала");
            System.out.println("\t2. Узнать принадлежность любого числа к интервалу");
            System.out.println("\t3. Узнать границы числового интервала");
            System.out.println("\t4. Изменить границы числового интервала");
            System.out.println("\t5. Получить пересечение двух интервалов");
            System.out.println("\t6. Получить объединение двух интервалов");
            System.out.println("\t7. Получить разность двух интервалов");
            System.out.println("\t8. Завершить программу");

            int selectedCommand = scanner.nextInt();
            int selectedRange = 0;

            if (selectedCommand == 1 || selectedCommand == 2 || selectedCommand == 3 || selectedCommand == 4) {
                System.out.println("Выберете числовой интервал (1-2):");
                System.out.println("\t1. Числовой интервал #1");
                System.out.println("\t2. Числовой интервал #2");

                selectedRange = scanner.nextInt();

                if (selectedRange != 1 && selectedRange != 2) {
                    System.out.println("Неизвестный числовой интервал");
                    continue;
                }
            }

            boolean isEnd = false;

            switch (selectedCommand) {
                case 1:
                    double length;

                    if (selectedRange == 1) {
                        length = range1.getLength();
                    } else {
                        length = range2.getLength();
                    }

                    System.out.println("Длина числового интервала составляет: " + length);
                    break;
                case 2:
                    System.out.println("Введите число:");
                    double number = scanner.nextDouble();
                    boolean isInside;

                    if (selectedRange == 1) {
                        isInside = range1.isInside(number);
                    } else {
                        isInside = range2.isInside(number);
                    }

                    if (isInside) {
                        System.out.println("Число принадлежит интервалу");
                    } else {
                        System.out.println("Число не принадлежит интервалу");
                    }

                    break;
                case 3:
                    if (selectedRange == 1) {
                        range1.print();
                    } else {
                        range2.print();
                    }

                    break;
                case 4:
                    System.out.println("Измените начало числового интервала:");
                    double changedFrom = scanner.nextDouble();

                    System.out.println("Измените конец числового интервала:");
                    double changedTo = scanner.nextDouble();

                    if (selectedRange == 1) {
                        range1.setFrom(changedFrom);
                        range1.setTo(changedTo);
                    } else {
                        range2.setFrom(changedFrom);
                        range2.setTo(changedTo);
                    }

                    System.out.println("Границы интервала изменены");
                    break;
                case 5:
                    Range intersectionRange = range1.getIntersection(range2);

                    if (intersectionRange == null) {
                        System.out.println("Интервалы не пересекаются");
                        break;
                    }

                    System.out.println("Границы интервала-пересечения равны:");
                    intersectionRange.print();

                    break;
                case 6:
                    Range[] rangesArray = range1.getUnion(range2);

                    if (rangesArray.length == 2) {
                        System.out.println("Границы интервалов-объединения равны:");

                        System.out.print("Интервал #1 - ");
                        rangesArray[0].print();

                        System.out.print("Интервал #2 - ");
                        rangesArray[1].print();
                    } else {
                        System.out.println("Границы интервала-объединения равны:");
                        rangesArray[0].print();
                    }

                    break;
                case 7:
                    rangesArray = range1.getDifference(range2);

                    if (rangesArray.length == 0) {
                        System.out.println("Интервал отсутствует");
                        break;
                    }

                    if (rangesArray.length == 2) {
                        System.out.println("Границы интервалов-разности равны:");

                        System.out.print("Интервал #1 - ");
                        rangesArray[0].print();

                        System.out.print("Интервал #2 - ");
                        rangesArray[1].print();
                    } else {
                        System.out.println("Границы интервала-разности равны:");
                        rangesArray[0].print();
                    }

                    break;
                case 8:
                    isEnd = true;
                    break;
                default:
                    System.out.println("Неизвестная команда");
            }

            if (isEnd) {
                break;
            }

            System.out.println();
        }
    }
}