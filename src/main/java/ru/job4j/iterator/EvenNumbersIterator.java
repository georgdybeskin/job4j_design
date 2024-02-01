package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return this.ifExist() == 0;
    }

    @Override
    public Integer next() {
        if (this.hasNext()) {
            return this.data[this.index++];
        } else {
            throw new NoSuchElementException();
        }
    }

    public Integer ifExist() {
        int value = -1;
        for (int index = this.index; index < this.data.length; index++) {
            if (this.data[index] % 2 == 0) {
                this.index = index;
                value++;
                break;
            }
        }
        return value;
    }
}