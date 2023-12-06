package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BackwardArrayIt implements Iterator<Integer> {
    private final int[] data;
    private int point;

    public BackwardArrayIt(int[] data) {
        this.data = data;
        this.point = data.length - 1;

        /* реализуйте конструктор */
    }

    @Override
    public boolean hasNext() {
        return point >= 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int trueValue = point;
        point--;
        System.out.println(data[trueValue]);
        return data[trueValue];
    }
    /**public int[] returnArrayBackwards(int[] data){

        for (int i = 0; i < data.length / 2; i++) {
            int j = data.length - 1 - i;
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
        return data;
    }**/
}
