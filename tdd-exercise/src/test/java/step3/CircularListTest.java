package step3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;

public class CircularListTest {

    private CircularList<Integer> circularList;

    private static final int NUMBER_OF_ELEMENTS = 10;

    @BeforeEach
    public void beforeEach() {
        this.circularList = new CircularListImpl<Integer>();
    }

    @Test
    public void atBeginningIsEmpty() {
        assertTrue(this.circularList.isEmpty());
    }

    @Test
    public void atBeginningIsZeroSized() {
        assertEquals(0, this.circularList.size());
    }

    @Test
    public void addItem() {
        this.circularList.add(0);
        assertFalse(this.circularList.isEmpty());
        assertEquals(1, this.circularList.size());
    }

    @Test
    public void filterNextInEmptyList() {
        assertEquals(Optional.empty(), this.circularList.filteredNext(elem -> true));
    }

    @Test
    public void filterNextFiltersCorrectly() {
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            this.circularList.add(i);
        }
        assertEquals(Optional.of(5), this.circularList.filteredNext(elem -> elem > 4));
    }

    @Test
    public void filterNextRetrievesNothing() {
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            this.circularList.add(i * 2);
        }
        assertEquals(Optional.empty(), this.circularList.filteredNext(elem -> elem % 2 == 1));
    }
}
