package tdd;

import java.util.Optional;
import java.util.List;
import java.util.LinkedList;

public class CircularListImpl implements CircularList {

    private final List<Integer> list;
    private int pointer;

    public CircularListImpl() {
        this.list = new LinkedList<Integer>();
    }

    public int getPointer() {
        return this.pointer;
    }

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        return this.iterate(true);
    }

    @Override
    public Optional<Integer> previous() {
        return this.iterate(false);
    }

    @Override
    public void reset() {
        this.pointer = 0;
    }

    @Override
    public String toString() {
        String output = "[ ";
        for (var item : this.list) {
            if (item == this.list.get(this.pointer)) {
                output += "(" + item + "), ";
            } else {
                output += item + ", ";
            }
        }
        return output.substring(0, output.length() - 2) + " ]";
    }

    private Optional<Integer> iterate(boolean isNext) {
        if (this.isEmpty()) {
            return Optional.empty();
        } else {
            movePointer(isNext);
            return Optional.of(this.list.get(this.pointer));
        }
    }

    private void movePointer(boolean isNext) {
        if (isNext) {
            this.pointer = (this.pointer + 1) % this.size();
        } else {
            this.pointer--;
            if (this.pointer < 0) this.pointer = this.size() + this.pointer;
        }
    }
}
