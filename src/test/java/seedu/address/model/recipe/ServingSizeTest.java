package seedu.address.model.recipe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class ServingSizeTest {
    ServingSize ss1 = new ServingSize(1);
    ServingSize ss2 = new ServingSize(2);

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
    public void toString_test() {
        assertEquals(ss1.toString(), String.valueOf(1));
    }

    @Test
    public void isValidServingSize() {
        assertTrue(ServingSize.isValidServingSize(3));
    }

    @Test
    public void equalityCheck() {
        ServingSize ss1_copy = new ServingSize(ss1.value);

        // ServingSize::equals
        assertNotEquals(ss1, ss1.value);
        assertEquals(ss1, ss1);
        assertEquals(ss1, ss1_copy);
        assertNotEquals(ss1, ss2);

        // ServingSize::hashCode
        assertEquals(ss1.hashCode(), ss1_copy.hashCode());
        assertNotEquals(ss1.hashCode(), ss2.hashCode());
    }
}
