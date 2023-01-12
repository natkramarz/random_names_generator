package org.example;

import java.util.List;
import java.util.Random;

public class ElementFromListGenerator<T> {

    private List<T> givenList;
    private Random random;


    public ElementFromListGenerator(List<T> givenList) {
        this.givenList = givenList;
        random = new Random();
    }

    public T generate() {
        return givenList.get(random.nextInt(givenList.size()));
    }
}
