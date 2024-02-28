package tdd;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;

/**
 * The test suite for testing the CircularList implementation
 */
public class EmptyCircularListTest {

    private CircularList circularList;

    @BeforeEach
    public void beforeEach() {
        circularList = new CircularListImpl();
    }

    @Test
    public void instance() {
        assertNotNull(circularList);
    }

    @Test
    public void isEmptyWhenInstantiated() {
        assertTrue(circularList.isEmpty());
    }

    @Test
    public void isSizeEqualsToZeroWhenInstantiated() {
        assertEquals(0, circularList.size());
    }

    @Test
    public void nextReturnEmptyOptionalWhenInstantiated() {
        assertEquals(circularList.next(), Optional.empty());
    }

    @Test
    public void previousReturnEmptyOptionalWhenInstantiated() {
        assertEquals(circularList.previous(), Optional.empty());
    }

    @Test
    public void resetDoNothingWhenInstantiated() {
        circularList.reset();
        nextReturnEmptyOptionalWhenInstantiated();
        previousReturnEmptyOptionalWhenInstantiated();
    }
}
