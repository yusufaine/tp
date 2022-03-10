package seedu.address.model.recipe;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class CompletionTimeTest {
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
}
