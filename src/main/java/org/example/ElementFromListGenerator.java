package org.example;

import java.util.Iterator;
import java.util.LinkedList;
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

    public Iterator<T> pickNRandomElements(int n) {
        var sublist = new LinkedList<T>();
        for (int i = 0; i < n; i++) {
            sublist.add(generate());
        }
        return sublist.iterator();
    }
}
