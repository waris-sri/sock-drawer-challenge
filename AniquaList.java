package Lect3;

import java.util.LinkedList;

public class AniquaList <T> extends LinkedList<T> {
    public Node first;

    public AniquaList() {
        first = null;
    }

    public AniquaList(int data) {       // Overload
        this.first = new Node(data);
    }

    @Override
    public boolean add(T elements) {
        Node newNode = new Node(elements);
        if(first == null) {
            first = newNode;
            return true;
        }
        Node current = first;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return true;
    }

    @Override
    public T remove(int index) {
        Node prev = first;
        Node current = first;
        int count = 0;
        if (current != null && count == index) {
            first = current.next;
            return (T) current.data;
        }
        while (current != null && count < index) {
            prev = current;
            current = current.next;
            count++;
        }
        if (current == null)
            return (T) prev.data;
        prev.next = current.next;
        return (T) current.data;
    }

    @Override
    public T get(int index) {
        Node current = first;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        return (T) current.data;
    }

    @Override
    public int size() {
        int count = 0;
        Node current = first;
        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

class Node <T> {
    public T data;
    public Node next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}