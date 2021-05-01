package ru.academits.shcheglov.list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public ListItem<T> getHead() {
        return head;
    }

    public int getCount() {
        return count;
    }

    private ListItem<T> getNode(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index must be >= 0");
        }

        if (index >= count) {
            throw new IndexOutOfBoundsException("Index must be < " + count);
        }

        ListItem<T> current = head;

        for (int i = 0; current != null; current = current.getNext(), i++) {
            if (i == index) {
                break;
            }
        }

        return current;
    }

    public T getData(int index) {
        return getNode(index).getData();
    }

    public T setData(int index, T newData) {
        T oldData = getNode(index).getData();
        getNode(index).setData(newData);
        return oldData;
    }

    public T removeHead() {
        T removedData = head.getData();
        head = head.getNext();
        count--;

        return removedData;
    }

    public T remove(int index) {
        if (index == 0) {
            return removeHead();
        }

        T removedData = getNode(index - 1).getNext().getData();
        getNode(index - 1).setNext(getNode(index).getNext());
        count--;

        return removedData;
    }

    public boolean remove(T data) {
        for (ListItem<T> current = head, previous = null; current != null; previous = current, current = current.getNext()) {
            if (current.getData().equals(data)) {
                if (previous != null) {
                    previous.setNext(current.getNext());
                    count--;

                    return true;
                }
            }
        }

        return false;
    }

    public void insertInHead(T element) {
        head = new ListItem<>(element, head);
        count++;
    }

    public void insert(int index, T element) {
        if (index == 0) {
            insertInHead(element);
            return;
        }

        getNode(index - 1).setNext(new ListItem<>(element, getNode(index - 1).getNext()));
        count++;
    }

    public SinglyLinkedList<T> getCopy() {
        SinglyLinkedList<T> newLinkedList = new SinglyLinkedList<>();

        if (count == 0) {
            return newLinkedList;
        }

        newLinkedList.head = new ListItem<>(head.getData());

        if (count == 1) {
            newLinkedList.count = count;
            return newLinkedList;
        }

        for (ListItem<T> oldNode = head.getNext(), newNode = newLinkedList.head; oldNode != null;
             oldNode = oldNode.getNext(), newNode = newNode.getNext()) {
            newNode.setNext(new ListItem<>(oldNode.getData(), oldNode.getNext()));
        }

        newLinkedList.count = count;

        return newLinkedList;
    }

    public void reverse() {
        if (count <= 1) {
            return;
        }

        ListItem<T> previous = head;
        ListItem<T> current = head.getNext();
        previous.setNext(null);

        for (int i = 0; i < count - 2; i++) {
            ListItem<T> temp = current.getNext();
            current.setNext(previous);
            previous = current;
            current = temp;
        }

        head = current;
        head.setNext(previous);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (ListItem<T> current = head; current != null; current = current.getNext()) {
            sb.append(current.getData()).append(", ");
        }

        sb.delete(sb.length() - 2, sb.length()).append("]");

        return String.valueOf(sb);
    }
}