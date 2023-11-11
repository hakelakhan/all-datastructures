package org.example;

import java.util.*;

public class MyLinkedList<E> extends AbstractSequentialList<E> implements List<E> {


    @Override
    public ListIterator<E> listIterator(int index) {
        Stack<Integer> s = new Stack<>();
        return null;
    }

    final class Node<E> {
        E e;
        Node<E> next;
        Node<E> prev;

        public Node() {
            prev = null;
            next = null;
            e = null;
        }
        public Node(E e) {
            this.e = e;
            this.next = null;
            this.prev = null;
        }
    }
    private  int size = 0;
    private Node<E> first = null;
    private Node<E> last = null;
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    private void linkLast(E e) {
        Node<E> newNode = new Node<>(e);


    }


    @Override
    public int size() {
        return size;
    }
}
