package tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;

public class CircularListWithMultipleElementsTest {

    private CircularList circularList;

    private static final int NUMBER_OF_ELEMENTS = 10;

    @BeforeEach
    public void beforeEach() {
        circularList = new CircularListImpl();
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            circularList.add(i);
        }
    }

    @Test
    public void sizeChangeAccordingly() {
        assertEquals(NUMBER_OF_ELEMENTS, circularList.size());
    }

    @Test
    public void isNotEmpty() {
        assertFalse(circularList.isEmpty());
    }

    @Test
    public void nextRetreivesTheFollowingElement() {
        int numberOfNext = 5;
        this.iterate(numberOfNext, true);
        assertEquals(Optional.of(6), circularList.next());
    }

    @Test
    public void previousRetreivesThePreviousElement() {
        int numberOfPrevious = 5;
        this.iterate(numberOfPrevious, false);
        assertEquals(Optional.of(4), circularList.previous());
    }

    @Test
    public void resetPointerToFirstElement() {
        this.nextRetreivesTheFollowingElement();
        circularList.reset();
        assertEquals(Optional.of(1), circularList.next());
    }

    @Test
    public void restartWhenOutOfBound() {
        int delta = 3;
        this.iterate(delta + NUMBER_OF_ELEMENTS, true);
        assertEquals(Optional.of(4), circularList.next());
    }

    @Test
    public void alwaysRestarts() {
        int numberOfCicles = 7;
        int delta = 4;
        this.iterate(numberOfCicles * NUMBER_OF_ELEMENTS + delta, false);
        assertEquals(Optional.of(5), circularList.previous());
    }

    private void iterate(int numberOfIterations, boolean isNext) {
        for (int i = 0; i < numberOfIterations; i++) {
            if (isNext) {
                circularList.next();
            } else {
                circularList.previous();
            }
        }
    }
}
