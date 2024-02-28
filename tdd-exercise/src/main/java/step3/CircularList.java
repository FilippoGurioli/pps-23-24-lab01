package step3;

import java.util.function.Predicate;
import java.util.Optional;

public interface CircularList<T> {

    boolean isEmpty();

    int size();

    void add(T element);

    Optional<T> filteredNext(Predicate<T> predicate);

}
