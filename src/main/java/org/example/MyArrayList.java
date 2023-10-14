package org.example;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class MyArrayList<E> extends AbstractList<E> implements List<E>/*, Cloneable, Serializable */{

    private Object[] elementData;
    private Object[] sharedElementData = {};
    private int size = 0;
    public MyArrayList() {
        elementData = sharedElementData;
    }
    public MyArrayList(int initialCapacity) {
        if(initialCapacity > 0 ) {
            grow( size(), initialCapacity);
        }
    }

    public boolean add(E e) {
        if(elementData.length == size()) {
            grow(size(), size() + 1);
        }
        elementData[size()] = e;
        size++;
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean removeIf(Predicate<? super E> filter) {
        boolean elementRemoved = false;
        for (int i = 0; i < size; i++) {
            if(filter.test((E)elementData[i])) {
                remove(i);
                elementRemoved = true;
            }
        }
        return elementRemoved;
    }
    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        E element = null;
        if(Objects.checkIndex(index, size) >= 0) {
            element = (E)elementData[index];
            fastRemove(index);
        }
        return element;
    }

    private void fastRemove(int index) {
        //skips index out of bound checkig
        //0     3   9
        // +   +x    +
        //     1
        System.arraycopy(elementData, index + 1, elementData, index, size - index  - 1);
        size--;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void replaceAll(UnaryOperator<E> operator) {
        for (int i = 0; i < size; i++) {
            E result = operator.apply((E)elementData[i]);
            elementData[i] = result;
        }
    }

    @Override
    public void sort(Comparator<? super E> c) {
        Collections.sort(this, c);
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if(Objects.checkIndex(index, size) >= 0) {
            return (E)elementData[index];
        }
        return null;
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        super.forEach(action);
    }

    @Override
    public Spliterator<E> spliterator() {
        return super.spliterator();
    }

    @Override
    public Stream<E> stream() {
        return super.stream();
    }

    @Override
    public Stream<E> parallelStream() {
        return super.parallelStream();
    }

    private void grow(int currentSize, int minGrowth) {
        int preferredGrowth = currentSize + currentSize >> 1;
        //we will go with max required growth
        int growth = Math.max(preferredGrowth, minGrowth);
        Object[] oldData = elementData;
        elementData = new Object[growth];
        System.arraycopy(oldData, 0, elementData, 0, currentSize);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return generator.apply(size);
    }
}
