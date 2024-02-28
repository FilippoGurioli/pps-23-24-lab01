package step2;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

public class CircularListImpl<E> implements CircularList<E> {

    private final List<E> list;

    public CircularListImpl() {
        this.list = new LinkedList<E>();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public Iterator<E> forwardIterator() {
        return getIterator(true);
    }

    @Override
    public Iterator<E> backwardIterator() {
        return getIterator(false);
    }
    
    private Iterator<E> getIterator(boolean isForward) {
        if (this.isEmpty()) throw new IllegalStateException("Cannot retrive an iterator of an empty list.");
        return new MyIterator(isForward);
    }

    @Override
    public void add(E element) {
        this.list.add(element);
    }

    private class MyIterator implements Iterator<E> {

        private int pointer = 0;
        private final boolean isForward;

        public MyIterator(boolean isForward) {
            this.isForward = isForward;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public E next() {
            if (this.isForward) {
                this.pointer++;
                this.pointer = this.pointer % size();
            } else {
                this.pointer--;
                if (this.pointer < 0) this.pointer = size() + this.pointer;
            }
            return list.get(this.pointer);
        }
        
    }
}
