package seedu.address.model.recipe;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class ServingSizeTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new ServingSize(null));
    }

    @Test
    public void constructor_invalidServingSize_throwsIllegalArgumentException() {
        int invalidServingSize = -3;
        assertThrows(IllegalArgumentException.class, () -> new ServingSize(invalidServingSize));
    }

    @Test
    public void isValidServingSize() {
        assertTrue(ServingSize.isValidServingSize(3));
    }
}
