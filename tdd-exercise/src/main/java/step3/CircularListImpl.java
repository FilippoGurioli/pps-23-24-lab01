package step3;

import java.util.function.Predicate;
import java.util.List;
import java.util.LinkedList;
import java.util.Optional;

public class CircularListImpl<T> implements CircularList<T> {

    private final List<T> list;
    private int pointer;

    public CircularListImpl() {
        this.list = new LinkedList<T>();
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
    public void add(T element) {
        this.list.add(element);
    }

    @Override
    public Optional<T> filteredNext(Predicate<T> predicate) {
        if (this.isEmpty()) return Optional.empty();
        else {
            var ret = this.list
                .stream()
                .filter(elem -> this.list.indexOf(elem) > pointer)
                .filter(predicate)
                .findFirst();
            if (ret.isPresent()) this.pointer = this.list.indexOf(ret.get());
            return ret;
        }
    }

}
