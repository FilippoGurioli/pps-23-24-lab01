package step2;

import java.util.Iterator;

public interface CircularList<E> {

    boolean isEmpty();

    int size();

    Iterator<E> forwardIterator();

    Iterator<E> backwardIterator();

    void add(E element);

}
