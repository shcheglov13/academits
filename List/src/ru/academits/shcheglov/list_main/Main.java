package ru.academits.shcheglov.list_main;

import ru.academits.shcheglov.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        for (int i = 0; i < 10; i++) {
            singlyLinkedList.insert(i, i + 1);
        }

        singlyLinkedList.insertInHead(10);
        System.out.println("SinglyLinkedList: " + singlyLinkedList);
        System.out.println("Count: " + singlyLinkedList.getCount());

        SinglyLinkedList<Integer> singlyLinkedListCopy = singlyLinkedList.getCopy();
        System.out.println("Copy of SinglyLinkedList: " + singlyLinkedListCopy);
        System.out.println("Count: " + singlyLinkedListCopy.getCount());

        Integer removedValue1 = singlyLinkedList.removeHead();
        System.out.println("SinglyLinkedList: " + singlyLinkedList);
        System.out.println("Removed value: " + removedValue1);

        Integer removedValue2 = singlyLinkedList.remove(5);
        System.out.println("SinglyLinkedList: " + singlyLinkedList);
        System.out.println("Removed value: " + removedValue2);

        boolean isRemoved = singlyLinkedList.remove(Integer.valueOf(3));
        System.out.println("SinglyLinkedList: " + singlyLinkedList);
        System.out.println("isRemoved = " + isRemoved);

        Integer value = singlyLinkedList.getData(4);
        System.out.println("value = " + value);

        singlyLinkedList.reverse();
        System.out.println("Reversed SinglyLinkedList: " + singlyLinkedList);
    }
}