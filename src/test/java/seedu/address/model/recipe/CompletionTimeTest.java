package seedu.address.model.recipe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class CompletionTimeTest {
    CompletionTime c1 = new CompletionTime(3);
    CompletionTime c2 = new CompletionTime(4);

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new CompletionTime(null));
    }

    @Test
    public void constructor_invalidCompletionTime_throwsIllegalArgumentException() {
        int invalidCompletionTime = -12;
        assertThrows(IllegalArgumentException.class, () -> new CompletionTime(invalidCompletionTime));
    }

    @Test
    public void isValidCompletionTime() {
        int validCompletionTime = 5;
        assertTrue(CompletionTime.isValidCompletionTime(validCompletionTime));
    }

    @Test
    public void toString_test() {
        assertEquals(c1.toString(), String.format("%d mins", c1.value));
    }

    @Test
    public void equalityCheck() {
        // Test CompletionTime::equals
        assertNotEquals(c1, c1.value);
        assertEquals(c1, c1);
        assertEquals(c1, new CompletionTime(c1.value));
        assertNotEquals(c1, c2);

        // Test hashCode
        assertEquals(c1.hashCode(), new CompletionTime(c1.value).hashCode());
        assertNotEquals(c1.hashCode(), c2.hashCode());
    }
}
