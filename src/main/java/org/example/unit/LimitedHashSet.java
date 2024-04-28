package org.example.unit;

import lombok.Getter;

import java.util.HashSet;

public class LimitedHashSet<E> extends HashSet<E> {

    @Getter
    public final int capacity;

    public LimitedHashSet(int capacity) {
        super();
        this.capacity = capacity;
    }

    public LimitedHashSet(LimitedHashSet<E> limitedHashSet) {
        super();
        capacity = limitedHashSet.getCapacity();
    }

    public boolean add(E e) {
        if (size() < capacity) {
            return super.add(e);
        }
        return false;
    }
}
