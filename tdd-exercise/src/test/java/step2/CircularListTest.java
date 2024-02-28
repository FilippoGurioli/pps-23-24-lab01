package step2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CircularListTest {
    
    private static final int NUMBER_OF_ITERATIONS = 12;
    private CircularList<Integer> list;

    @BeforeEach
    public void instance() {
        this.list = new CircularListImpl<Integer>();
    }

    @Test
    public void noElementsMeansIsEmpty() {
        assertTrue(this.list.isEmpty());
    }

    @Test
    public void sizeIsZeroWhenEmpty() {
        assertEquals(0, this.list.size());
    }

    @Test
    public void isIllegalToCallForwardWhenEmpty() {
        assertThrows(IllegalStateException.class, () -> this.list.forwardIterator());
    }

    @Test
    public void isIllegalToCallBackwardWhenEmpty() {
        assertThrows(IllegalStateException.class, () -> this.list.backwardIterator());
    }

    @Test
    public void addItem() {
        this.list.add(0);
        assertFalse(this.list.isEmpty());
        assertEquals(1, this.list.size());
    }

    @Test
    public void forwardIteratorShouldIterate() {
        this.populateList();
        var iterator = this.list.forwardIterator();
        int iterations = 2;
        for (int i = 0; i < iterations; i++) {
            iterator.next();
        }
        assertEquals(3, iterator.next());
    }

    @Test
    public void backwardIteratorShouldIterate() {
        this.populateList();
        var iterator = this.list.backwardIterator();
        int iterations = 2;
        for (int i = 0; i < iterations; i++) {
            iterator.next();
        }
        assertEquals(NUMBER_OF_ITERATIONS - 3, iterator.next());
    }

    @Test
    public void forwardHasNextShouldNeverBeFalse() {
        populateList();
        var iterator = this.list.forwardIterator();
        int iterations = 50;
        for (int i = 0; i < iterations; i++) {
            if (iterator.hasNext()) iterator.next();
            else fail();
        }
    }

    @Test
    public void backwardHasNextShouldNeverBeFalse() {
        populateList();
        var iterator = this.list.backwardIterator();
        int iterations = 50;
        for (int i = 0; i < iterations; i++) {
            if (iterator.hasNext()) iterator.next();
            else fail();
        }
    }

    private void populateList() {
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            this.list.add(i);
        }
    }
}
