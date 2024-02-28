package tdd;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;

public class CircularListWithOneElementTest {
    
    private CircularList circularList;

    private static final int ITEM = 0;

    @BeforeEach
    public void beforeEach() {
        circularList = new CircularListImpl();
        circularList.add(ITEM); //in this tests the list must have at least one element
    }

    @Test
    public void addItemChangesTheSize() {
        assertEquals(1, circularList.size());
    }

    @Test
    public void addItemMakesTheListNotEmpty() {
        assertFalse(circularList.isEmpty());
    }

    @Test
    public void addItemMakesNextRetrieveIt() {
        assertEquals(Optional.of(ITEM), circularList.next());
    }

    @Test
    public void addItemMakesPreviousRetrieveIt() {
        assertEquals(Optional.of(ITEM), circularList.previous());
    }

    @Test
    public void resetDoNothingWithOneElement() {
        circularList.reset();
        addItemMakesNextRetrieveIt();
        addItemMakesPreviousRetrieveIt();
    }
}
